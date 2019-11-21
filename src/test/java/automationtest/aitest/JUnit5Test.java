package automationtest.aitest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class JUnit5Test {
    private WebDriver driver;
    private static final String baseUrl = "http://www.google.com";
//    private boolean acceptNextAlert = true;
//    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeAll
    static void setUpBeforeClass() throws Exception {

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","exe/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(baseUrl);
        driver.findElement(By.name("q")).sendKeys("Seleniumで検索テスト");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.close();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        //fail("まだ実装されていません");
    }

}
