package automationtest.aitest.factory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

import automationtest.aitest.webdriver.AutoTestTargetLocatorImpl;
import automationtest.aitest.webdriver.AutoTestWebDriverImpl;
import automationtest.aitest.webdriver.AutoTestWebElementImpl;

public class AutoTestFactory implements TesterFactory {

//  private static final WebDriver driver = new AITestWebDriverImpl(new ChromeDriver());
  @Override
  public WebDriver getWebDriver(WebDriver argRawDriver) {
    return new AutoTestWebDriverImpl(argRawDriver);
  }

  @Override
  public WebElement getWebElement(WebElement argRawElement, By argLocator) {
    return new AutoTestWebElementImpl(argRawElement, null, argLocator);
  }

  @Override
  public TargetLocator getTargetLocator(TargetLocator argRawTargetLocator) {
    return new AutoTestTargetLocatorImpl(argRawTargetLocator);
  }

  @Override
  public Alert getAlert() {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

}
