package automationtest.aitest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author kai
 *
 */
public class WebElementProxy {

  protected static final Logger logger = LoggerFactory.getLogger(WebElementProxy.class);

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
