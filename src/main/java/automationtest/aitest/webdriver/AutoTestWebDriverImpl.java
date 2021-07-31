package automationtest.aitest.webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationtest.aitest.proxy.WebDriverProxy;
import automationtest.aitest.proxy.handler.RetryHandler;
import automationtest.aitest.utils.AutoTestUtils;

/**
 * 
 * @author kai
 *
 */
public class AutoTestWebDriverImpl implements AutoTestWebDriver {

  //The name of this Logge will be "automationtest.aitest.webdriver.AITestWebDriver"
  protected static final Logger logger = LoggerFactory.getLogger(AutoTestWebDriverImpl.class);

  private final WebDriver rawWebDriver;

  private final WebDriver rawWebDriverProxy;

  /**
   * コンストラクター
   * @param argWrappedWebDriver
   */
  public AutoTestWebDriverImpl(WebDriver argWebDriver) {
    if (argWebDriver == null) {
      throw new IllegalArgumentException("argWrappedWebDriver can not be null;");
    }

    this.rawWebDriver = argWebDriver;
    this.rawWebDriverProxy = WebDriverProxy.createProxy(new RetryHandler(argWebDriver));

    /************************ implicity wati option ****************************/
    argWebDriver.manage().timeouts().implicitlyWait(AutoTestUtils.getConf().getImplicityWaitMilliseconds(),
        TimeUnit.MILLISECONDS);

  }

  @Override
  public void get(String url) {
    this.getRawWebDriverProxy().get(url);
  }

  @Override
  public String getCurrentUrl() {
    return this.getRawWebDriverProxy().getCurrentUrl();
  }

  @Override
  public String getTitle() {
    return this.getRawWebDriverProxy().getTitle();
  }

  @Override
  public List<WebElement> findElements(By by) {
    List<WebElement> wrappers = new ArrayList<WebElement>();

    // OldBy to NewBy
    List<WebElement> rawElements = this.getRawWebDriverProxy().findElements(by);

    if (rawElements == null || rawElements.size() <= 0) {
      return wrappers;
    }

    for (WebElement rawElement : rawElements) {
      wrappers.add(new AutoTestWebElementImpl(rawElement, null, by));
    }

    return wrappers;
  }

  @Override
  public WebElement findElement(By by) {
    //    private static void WaitForReady()
    //    {
    //        WebDriverWait wait = new WebDriverWait(webDriver, waitForElement);
    //        wait.Until(driver =>
    //        {
    //            bool isAjaxFinished = (bool)((IJavaScriptExecutor)driver).
    //                ExecuteScript("return jQuery.active == 0");
    //            bool isLoaderHidden = (bool)((IJavaScriptExecutor)driver).
    //                ExecuteScript("return $('.spinner').is(':visible') == false");
    //            return isAjaxFinished & isLoaderHidden;
    //        });
    //    }

    WebElement rawElement = this.getRawWebDriverProxy().findElement(by);
    return new AutoTestWebElementImpl(rawElement, null, by);
  }

  @Override
  public String getPageSource() {
    return this.getRawWebDriverProxy().getPageSource();
  }

  @Override
  public void close() {
    this.getRawWebDriverProxy().close();
  }

  @Override
  public void quit() {
    this.getRawWebDriverProxy().quit();
  }

  @Override
  public Set<String> getWindowHandles() {
    return this.getRawWebDriverProxy().getWindowHandles();
  }

  @Override
  public String getWindowHandle() {
    return this.getRawWebDriverProxy().getWindowHandle();
  }

  @Override
  public TargetLocator switchTo() {
    TargetLocator wrappedTargetLocator = this.getRawWebDriverProxy().switchTo();
    return new AutoTestTargetLocatorImpl(wrappedTargetLocator);
  }

  @Override
  public Navigation navigate() {
    return this.getRawWebDriverProxy().navigate();
  }

  @Override
  public Options manage() {
    return this.getRawWebDriverProxy().manage();
  }

  @Override
  public WebDriver getRawWebDriver() {
    return rawWebDriver;
  }

  public WebDriver getRawWebDriverProxy() {
    return rawWebDriverProxy;
  }

}
