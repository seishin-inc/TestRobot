package automationtest.aitest.webdriver;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AITestWebDriver implements WebDriver {

  //The name of this Logge will be "automationtest.aitest.webdriver.AITestWebDriver"
  protected static final Logger logger = LogManager.getLogger();

  private WebDriver rawWebDriver = null;

  /**
   * コンストラクター
   * @param argWrappedWebDriver
   */
  public AITestWebDriver (WebDriver argWrappedWebDriver) {
    if (argWrappedWebDriver == null) {
      throw new IllegalArgumentException("argWrappedWebDriver can not be null;");
    }

    this.rawWebDriver = argWrappedWebDriver;
  }

  @Override
  public void get(String url) {
    this.getRawWebDriver().get(url);
  }

  @Override
  public String getCurrentUrl() {
    return this.getRawWebDriver().getCurrentUrl();
  }

  @Override
  public String getTitle() {
    return this.getRawWebDriver().getTitle();
  }

  @Override
  public List<WebElement> findElements(By by) {
    return this.getRawWebDriver().findElements(by);
  }

  @Override
  public WebElement findElement(By by) {
    return this.getRawWebDriver().findElement(by);
  }

  @Override
  public String getPageSource() {
    return this.getRawWebDriver().getPageSource();
  }

  @Override
  public void close() {
    this.getRawWebDriver().close();
  }

  @Override
  public void quit() {
    this.getRawWebDriver().quit();
  }

  @Override
  public Set<String> getWindowHandles() {
    return this.getRawWebDriver().getWindowHandles();
  }

  @Override
  public String getWindowHandle() {
    return this.getRawWebDriver().getWindowHandle();
  }

  @Override
  public TargetLocator switchTo() {
    return this.getRawWebDriver().switchTo();
  }

  @Override
  public Navigation navigate() {
    return this.getRawWebDriver().navigate();
  }

  @Override
  public Options manage() {
    return this.getRawWebDriver().manage();
  }

  public WebDriver getRawWebDriver() {
    return rawWebDriver;
  }

  public void setRawWebDriver(WebDriver rawWebDriver) {
    this.rawWebDriver = rawWebDriver;
  }

}
