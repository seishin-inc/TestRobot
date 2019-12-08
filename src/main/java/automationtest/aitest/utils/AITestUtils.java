package automationtest.aitest.utils;

import org.openqa.selenium.WebDriver;

import automationtest.aitest.configuration.Configuration;
import automationtest.aitest.configuration.ConfigurationManager;

public class AITestUtils {

  /**
   * コンストラクター<br>
   * インスタンス作成を防ぐため、私有化する
   */
  private AITestUtils() {

  }

  /**
   *
   * @return
   */
  public static Configuration getConf() {
    return ConfigurationManager.getInstance().getConf();
  }

  public static void switchToTop(WebDriver driver) {

  }


}
