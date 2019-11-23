package automationtest.aitest.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import automationtest.aitest.exception.AITestException;
import automationtest.aitest.utils.AITestUtils;

/**
 *
 * @author kai
 *
 */
public class RetryHandler implements InvocationHandler {

  private static Logger logger = LogManager.getLogger();

  private Object target;

  public RetryHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //System.out.println("DynamicProxy:before");
    logger.trace("DynamicProxy:before");

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
          logger.warn("対象が存在なし。リトライ発生");
        } else if (cause instanceof StaleElementReferenceException) {
          //対象が古かった
          logger.warn("対象が古かった。リトライ発生");
        } else if (cause instanceof ElementNotVisibleException) {
          //対象が一時的に利用不可
          logger.warn("対象が一時的に利用不可。リトライ発生");
        } else {
          logger.error("想定外異常発生しました。");
          throw ex;
        }

        //CPUを独占しないように、リトライ処理の間に間隔時間をあける
        Thread.sleep(AITestUtils.getConf().getRetryIntervalMilliseonds());

        end = System.currentTimeMillis();
        if (end - start > AITestUtils.getConf().getMaxRetryWaitMilliseconds()) {
          throw new AITestException("最大待ち時間を超えたため、処理を終了する。");
        }

      }
    }

    //System.out.println("DynamicProxy:after");
    logger.trace("DynamicProxy:after");

    return result;
  }

}
