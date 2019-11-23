package automationtest.aitest.utils;

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



}
