package automationtest.aitest.exception;

import automationtest.aitest.configuration.ConfigurationManager;

public class AutoTestException extends RuntimeException {

  /**
   * 現時点環境設定情報（調査時利用すると想定する）
   */
  private final String confJsonString  = ConfigurationManager.getInstance().toString();

  public AutoTestException() {
    super();
    // TODO 自動生成されたコンストラクター・スタブ
  }

  public AutoTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    // TODO 自動生成されたコンストラクター・スタブ
  }

  public AutoTestException(String message, Throwable cause) {
    super(message, cause);
    // TODO 自動生成されたコンストラクター・スタブ
  }

  public AutoTestException(String message) {
    super(message);
    // TODO 自動生成されたコンストラクター・スタブ
  }

  public AutoTestException(Throwable cause) {
    super(cause);
    // TODO 自動生成されたコンストラクター・スタブ
  }

  public String getConfJsonString() {
    return confJsonString;
  }

}
