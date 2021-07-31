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

  private WebElement webElement;

  private WebElementProxy(InvocationHandler argHanlder) {
    Object proxy = Proxy.newProxyInstance(
        WebElement.class.getClassLoader(),
        new Class[] { WebElement.class },
        argHanlder);

    if (proxy instanceof WebElement) {
      this.webElement = (WebElement) proxy;
    }
  }

  /**
   * 外部からはこのメソッドを通じてProxyを取得します.
   * @param argHandler
   * @return
   */
  public static WebElement createProxy(InvocationHandler argHandler) {
    WebElementProxy webElementProxy = new WebElementProxy(argHandler);

    WebElement webElement = null;

    if (webElementProxy.webElement instanceof WebElement) {
      webElement = WebElement.class.cast(webElementProxy.webElement);
    }
    return webElement;

  }

}
