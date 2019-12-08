package automationtest.aitest.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AITestTargetLocator implements TargetLocator {

  private static final Logger logger = LoggerFactory.getLogger(AITestTargetLocator.class);

  private final TargetLocator rawTargetLocator;

  /**
   * コンストラクター
   * @param argWrappedTargetLocator
   */
  public AITestTargetLocator(TargetLocator argWrappedTargetLocator) {

    if (argWrappedTargetLocator == null) {
      throw new IllegalArgumentException("argWrappedTargetLocator can not be null;");
    }

    this.rawTargetLocator = argWrappedTargetLocator;
  }

  @Override
  public WebDriver frame(int index) {
    // TODO 自動生成されたメソッド・スタブ
    return this.getRawTargetLocator().frame(index);
  }

  @Override
  public WebDriver frame(String nameOrId) {
    // TODO 自動生成されたメソッド・スタブ
    return this.getRawTargetLocator().frame(nameOrId);
  }

  @Override
  public WebDriver frame(WebElement frameElement) {
    // TODO 自動生成されたメソッド・スタブ
    return this.getRawTargetLocator().frame(frameElement);
  }

  @Override
  public WebDriver parentFrame() {
    // TODO 自動生成されたメソッド・スタブ
    return this.getRawTargetLocator().parentFrame();
  }

  @Override
  public WebDriver window(String nameOrHandle) {
    // TODO 自動生成されたメソッド・スタブ
    return this.getRawTargetLocator().window(nameOrHandle);
  }

  @Override
  public WebDriver defaultContent() {
    // TODO 自動生成されたメソッド・スタブ
    return this.getRawTargetLocator().defaultContent();
  }

  @Override
  public WebElement activeElement() {
    // TODO 自動生成されたメソッド・スタブ
    return this.getRawTargetLocator().activeElement();
  }

  @Override
  public Alert alert() {

    return this.getRawTargetLocator().alert();
  }

  public TargetLocator getRawTargetLocator() {
    return rawTargetLocator;
  }

}
