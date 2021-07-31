package automationtest.aitest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationtest.aitest.utils.AutoTestUtils;
import automationtest.aitest.webdriver.AutoTestWebDriver;
import automationtest.aitest.webdriver.AutoTestWebDriverImpl;

public class JUnit4Test2 {

    private WebDriver driver;
    private String baseUrl = "";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final Logger logger = LoggerFactory.getLogger(JUnit4Test2.class);

//    @Rule
//    public TestName testName = new TestName();

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    public JUnit4Test2() {

    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "exe/chromedriver");
        this.driver = new AutoTestWebDriverImpl(new ChromeDriver());
        this.baseUrl = "https://www.katalon.com/";
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://example.selenium.jp/reserveApp_Renewal/");
//        driver.findElement(By.id("reserve_year")).click();
//        driver.findElement(By.id("reserve_year")).clear();
//        driver.findElement(By.id("reserve_year")).sendKeys("2018");
//        driver.findElement(By.id("reserve_month")).click();
//        driver.findElement(By.id("reserve_month")).clear();
//        driver.findElement(By.id("reserve_month")).sendKeys("8");
//        driver.findElement(By.id("reserve_day")).click();
//        driver.findElement(By.id("reserve_day")).clear();
//        driver.findElement(By.id("reserve_day")).sendKeys("2");
//        driver.findElement(By.id("breakfast_off")).click();
//        driver.findElement(By.id("plan_a")).click();
//        driver.findElement(By.id("plan_b")).click();
//        driver.findElement(By.id("guestname")).click();
//        driver.findElement(By.id("guestname")).clear();
//        driver.findElement(By.id("guestname")).sendKeys("tewst");

        List<Map<String, String>> inputList = AutoTestUtils.getInputList(((AutoTestWebDriver)this.driver).getRawWebDriver());
        logger.debug("inpulist:");

        driver.findElement(By.id("goto_next")).click();
       // driver.
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            //fail(verificationErrorString);
        }
    }

//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }

//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }

}
