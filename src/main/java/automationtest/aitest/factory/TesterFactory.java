package automationtest.aitest.factory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

public interface TesterFactory {

  WebDriver getWebDriver(WebDriver argRawDriver);

  WebElement getWebElement(WebElement argRawWebElement, By argLocator);

  TargetLocator getTargetLocator(TargetLocator argTargetLocator);

  Alert getAlert();


}
