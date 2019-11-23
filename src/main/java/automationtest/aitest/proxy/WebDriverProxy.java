package automationtest.aitest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverProxy {

  protected Logger logger = LogManager.getLogger();

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
