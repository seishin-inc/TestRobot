package automationtest.aitest.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationtest.aitest.proxy.WebElementProxy;
import automationtest.aitest.proxy.handler.RetryHandler;
import automationtest.aitest.utils.AITestUtils;

public class AITestWebElementImpl implements AITestWebElement {

  private static final Logger logger = LoggerFactory.getLogger(AITestWebElement.class);

  private final WebElement rawWebElement;

  private final WebElement rawWebElementProxy;

  private final WebDriverWait wait;

  private final WebDriver wrappedDriver;

  /**
   * コンストラクター
   * @param argWrappedWebDriver
   */
  public AITestWebElementImpl(WebElement argWrappedWebElement) {
    if (argWrappedWebElement == null) {
      throw new IllegalArgumentException("argWrappedWebElement can not be null;");
    }

    this.rawWebElementProxy = WebElementProxy.createProxy(new RetryHandler(argWrappedWebElement));
    this.rawWebElement = argWrappedWebElement;
    this.wrappedDriver = getWrappedDriver();
    this.wait = new WebDriverWait(wrappedDriver, AITestUtils.getConf().getExplicityWaitSeconds());

  }

  @Override
  public void click() {
    this.getRawWebElementProxy().click();

  }

  @Override
  public void submit() {
    this.getRawWebElementProxy().submit();

  }

  @Override
  public void sendKeys(CharSequence... keysToSend) {
    this.getRawWebElementProxy().sendKeys(keysToSend);

  }

  @Override
  public void clear() {
    this.getRawWebElementProxy().clear();

  }

  @Override
  public String getTagName() {
    return this.getRawWebElementProxy().getTagName();
  }

  @Override
  public String getAttribute(String name) {
    return this.getRawWebElementProxy().getAttribute(name);
  }

  @Override
  public boolean isSelected() {
    return this.getRawWebElementProxy().isSelected();
  }

  @Override
  public boolean isEnabled() {
    return this.getRawWebElementProxy().isEnabled();
  }

  @Override
  public String getText() {
    return this.getRawWebElementProxy().getText();
  }

  @Override
  public List<WebElement> findElements(By by) {
    return this.getRawWebElementProxy().findElements(by);
  }

  @Override
  public WebElement findElement(By by) {
    return this.getRawWebElementProxy().findElement(by);
  }

  @Override
  public boolean isDisplayed() {
    return this.getRawWebElementProxy().isDisplayed();
  }

  @Override
  public Point getLocation() {
    return this.getRawWebElementProxy().getLocation();
  }

  @Override
  public Dimension getSize() {
    return this.getRawWebElementProxy().getSize();
  }

  @Override
  public Rectangle getRect() {
    return this.getRawWebElementProxy().getRect();
  }

  @Override
  public String getCssValue(String propertyName) {
    return this.getRawWebElementProxy().getCssValue(propertyName);
  }

  @Override
  public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
    return this.getRawWebElementProxy().getScreenshotAs(target);
  }

  public WebElement getRawWebElement() {
    return this.rawWebElement;
  }

  public WebElement getRawWebElementProxy() {
    return this.rawWebElementProxy;
  }

  @Override
  public WebDriver getWrappedDriver() {
    WebDriver wrappedDriver = null;
    if (this.rawWebElement instanceof WrapsDriver) {
      WrapsDriver wraps = (WrapsDriver) this.rawWebElement;
      wrappedDriver = wraps.getWrappedDriver();
    }
    return wrappedDriver;
  }

}
