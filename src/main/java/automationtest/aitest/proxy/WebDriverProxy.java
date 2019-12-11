package automationtest.aitest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverProxy {

  protected static final Logger logger =  LoggerFactory.getLogger(WebDriverProxy.class);

  //private WebDriver webDriver;
  private Object driver;

  private WebDriverProxy(InvocationHandler argHanlder) {
      //this.webDriver = argWebDriver;
      this.driver = Proxy.newProxyInstance(
          WebDriver.class.getClassLoader(),
          new Class[]{ WebDriver.class },
          argHanlder);
  }

  /**
   * 外部からはこのメソッドを通じてProxyを取得します.
   */
  public static WebDriver createProxy(InvocationHandler argHandler) {
    WebDriverProxy webDriverProxy = new WebDriverProxy(argHandler);

    WebDriver webDriver = null;

    if (webDriverProxy.driver instanceof WebDriver) {
      webDriver =  WebDriver.class.cast(webDriverProxy.driver);
    }

    return webDriver;
  }

}
