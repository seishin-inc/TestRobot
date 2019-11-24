package automationtest.aitest.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationtest.aitest.exception.AITestException;
import automationtest.aitest.utils.AITestUtils;

/**
 *
 * @author kai
 *
 */
public class RetryHandler implements InvocationHandler {

  private static Logger logger = LoggerFactory.getLogger(RetryHandler.class);//LogManager.getLogger();

  private Object target;

  public RetryHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //System.out.println("DynamicProxy:before");
    logger.trace("before:{}-{}-{}",method.getDeclaringClass().getSimpleName(), method.getName(),args);

    Object result = null;

    long start = 0;
    long end = 0;
    start = System.currentTimeMillis();

    while (true) {
      try {
        result = method.invoke(target, args);
        break;
      } catch (InvocationTargetException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof NoSuchElementException) {
          //対象が存在なし
          logger.warn("NoSuchElementException 対象が存在なし。リトライ発生");
          logger.trace(ex.getMessage(), ex);
        } else if (cause instanceof StaleElementReferenceException) {
          //対象が古かった
          logger.warn("NoSuchElementException 対象が古かった。リトライ発生");
          logger.trace(ex.getMessage(), ex);
        } else if (cause instanceof ElementNotVisibleException) {
          //対象が一時的に利用不可
          logger.warn("ElementNotVisibleException 対象が一時的に利用不可。リトライ発生");
          logger.trace(ex.getMessage(), ex);
        } else {
          logger.error("想定外異常発生しました。", ex);
          throw ex;
        }

        //CPUを独占しないように、リトライ処理の間に間隔時間をあける
        Thread.sleep(AITestUtils.getConf().getRetryIntervalMilliseonds());

        end = System.currentTimeMillis();
        long maxRetryWaitMs = AITestUtils.getConf().getMaxRetryWaitMilliseconds();
        if (end - start > maxRetryWaitMs) {
          throw new AITestException("最大待ち時間を超えたため、処理を終了する。");
        }

      }
    }

    logger.trace("after:{}-{}", method.getDeclaringClass().getSimpleName(), method.getName());

    return result;
  }

}
