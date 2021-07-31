package automationtest.aitest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverProxy {

  protected static final Logger logger = LoggerFactory.getLogger(WebDriverProxy.class);

  private WebDriver driver = null;

  /**
   * コンストラクター.
   * @param argHanlder
   */
  private WebDriverProxy(InvocationHandler argInvocationHanlder) {
    // handlerを設定して、Proxyのインスタンスを作成する
    Object proxy = Proxy.newProxyInstance(
        WebDriver.class.getClassLoader(),
        new Class[] { WebDriver.class },
        argInvocationHanlder);

    if (proxy instanceof WebDriver) {
      driver = (WebDriver) proxy;
    }
  }

  /**
   * 外部からはこのメソッドを通じてProxyを取得します.
   */
  public static WebDriver createProxy(InvocationHandler argHandler) {
    WebDriverProxy webDriverProxy = new WebDriverProxy(argHandler);

    WebDriver webDriver = null;

    if (webDriverProxy.driver instanceof WebDriver) {
      webDriver = WebDriver.class.cast(webDriverProxy.driver);
    }

    return webDriver;
  }

}
