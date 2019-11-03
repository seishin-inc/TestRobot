package automationtest.aitest;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


class UnitTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeEach
    public void setUp() throws Exception {
      driver = new FirefoxDriver();
      baseUrl = "https://www.katalon.com/";
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @ExtendWith(TestWatcher.class)
    @Test
    public void testUntitledTestCase() throws Exception {
      driver.get("http://example.selenium.jp/reserveApp/");
      driver.findElement(By.id("reserve_year")).click();
      driver.findElement(By.id("reserve_year")).clear();
      driver.findElement(By.id("reserve_year")).sendKeys("2018");
      driver.findElement(By.id("reserve_month")).click();
      driver.findElement(By.id("reserve_month")).clear();
      driver.findElement(By.id("reserve_month")).sendKeys("8");
      driver.findElement(By.id("reserve_day")).click();
      driver.findElement(By.id("reserve_day")).clear();
      driver.findElement(By.id("reserve_day")).sendKeys("2");
      driver.findElement(By.id("breakfast_off")).click();
      driver.findElement(By.id("plan_a")).click();
      driver.findElement(By.id("plan_b")).click();
      driver.findElement(By.id("guestname")).click();
      driver.findElement(By.id("guestname")).clear();
      driver.findElement(By.id("guestname")).sendKeys("tewst");
      driver.findElement(By.id("goto_next")).click();
    }

    @AfterEach
    public void tearDown() throws Exception {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        //fail(verificationErrorString);
      }
    }

    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    private String closeAlertAndGetItsText() {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }

}
