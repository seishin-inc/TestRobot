package automationtest.aitest.factory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

import automationtest.aitest.webdriver.AITestTargetLocatorImpl;
import automationtest.aitest.webdriver.AITestWebDriverImpl;
import automationtest.aitest.webdriver.AITestWebElementImpl;

public class AITestFactory implements TesterFactory {

//  private static final WebDriver driver = new AITestWebDriverImpl(new ChromeDriver());
  @Override
  public WebDriver getWebDriver(WebDriver argRawDriver) {
    return new AITestWebDriverImpl(argRawDriver);
  }

  @Override
  public WebElement getWebElement(WebElement argRawElement, By argLocator) {
    return new AITestWebElementImpl(argRawElement, null, argLocator);
  }

  @Override
  public TargetLocator getTargetLocator(TargetLocator argRawTargetLocator) {
    return new AITestTargetLocatorImpl(argRawTargetLocator);
  }

  @Override
  public Alert getAlert() {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

}
