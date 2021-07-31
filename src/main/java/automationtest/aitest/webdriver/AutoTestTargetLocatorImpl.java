package automationtest.aitest.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoTestTargetLocatorImpl implements AutoTestTargetLocator {

  private static final Logger logger = LoggerFactory.getLogger(AutoTestTargetLocatorImpl.class);

  private final TargetLocator rawTargetLocator;

  /**
   * コンストラクター
   * @param argWrappedTargetLocator
   */
  public AutoTestTargetLocatorImpl(TargetLocator argWrappedTargetLocator) {

    if (argWrappedTargetLocator == null) {
      throw new IllegalArgumentException("argWrappedTargetLocator can not be null;");
    }

    this.rawTargetLocator = argWrappedTargetLocator;
  }

  @Override
  public WebDriver frame(int index) {
    return this.getRawTargetLocator().frame(index);
  }

  @Override
  public WebDriver frame(String nameOrId) {
    return this.getRawTargetLocator().frame(nameOrId);
  }

  @Override
  public WebDriver frame(WebElement frameElement) {
    return this.getRawTargetLocator().frame(frameElement);
  }

  @Override
  public WebDriver parentFrame() {
    return this.getRawTargetLocator().parentFrame();
  }

  @Override
  public WebDriver window(String nameOrHandle) {
    return this.getRawTargetLocator().window(nameOrHandle);
  }

  @Override
  public WebDriver defaultContent() {
    return this.getRawTargetLocator().defaultContent();
  }

  @Override
  public WebElement activeElement() {
    return this.getRawTargetLocator().activeElement();
  }

  @Override
  public Alert alert() {
    //Apが標準Alertを利用する場合（標準Alertを利用しない場合、別途実装要）
    return this.getRawTargetLocator().alert();
  }

  public TargetLocator getRawTargetLocator() {
    return rawTargetLocator;
  }

}
