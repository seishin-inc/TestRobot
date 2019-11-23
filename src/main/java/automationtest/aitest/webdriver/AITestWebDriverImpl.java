package automationtest.aitest.webdriver;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationtest.aitest.proxy.WebDriverProxy;
import automationtest.aitest.proxy.handler.RetryHandler;

/**
 *
 * @author kai
 *
 */
public class AITestWebDriverImpl implements AITestWebDriver {

  //The name of this Logge will be "automationtest.aitest.webdriver.AITestWebDriver"
  protected static final Logger logger = LogManager.getLogger();

  private final WebDriver rawWebDriver;

  private final WebDriver rawWebDriverProxy;

  /**
   * コンストラクター
   * @param argWrappedWebDriver
   */
  public AITestWebDriverImpl(WebDriver argWrappedWebDriver) {
    if (argWrappedWebDriver == null) {
      throw new IllegalArgumentException("argWrappedWebDriver can not be null;");
    }

    this.rawWebDriverProxy = WebDriverProxy.createProxy(new RetryHandler(argWrappedWebDriver));
    this.rawWebDriver = argWrappedWebDriver;
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
    // OldBy to NewBy
    return this.getRawWebDriverProxy().findElements(by);
  }

  @Override
  public WebElement findElement(By by) {
    return this.getRawWebDriverProxy().findElement(by);
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
     return new AITestTargetLocator(wrappedTargetLocator);
  }

  @Override
  public Navigation navigate() {
    return this.getRawWebDriverProxy().navigate();
  }

  @Override
  public Options manage() {
    return this.getRawWebDriverProxy().manage();
  }

  public WebDriver getRawWebDriver() {
    return rawWebDriver;
  }

  public WebDriver getRawWebDriverProxy() {
    return rawWebDriverProxy;
  }

}
