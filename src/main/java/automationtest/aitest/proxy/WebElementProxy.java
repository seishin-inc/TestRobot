package automationtest.aitest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 *
 * @author kai
 *
 */
public class WebElementProxy {

  protected Logger logger = LogManager.getLogger();

  private Object webElement;

  private WebElementProxy(InvocationHandler argHanlder) {
      this.webElement = Proxy.newProxyInstance(
          WebElement.class.getClassLoader(),
          new Class[]{ WebElement.class },
          argHanlder);
  }

  /**
   * 外部からはこのメソッドを通じてProxyを取得します.
   */
  public static WebElement createProxy(InvocationHandler argHandler) {
    WebElementProxy webElementProxy = new WebElementProxy(argHandler);

    WebElement webElement = null;

    if (webElementProxy.webElement instanceof WebElement) {
      webElement =  WebElement.class.cast(webElementProxy.webElement);
    }
    return webElement;

  }

}
