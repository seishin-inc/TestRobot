package automationtest.aitest.utils;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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

  @SuppressWarnings("unchecked")
  public static List<Map<String, String>> getInputList(WebDriver argDriver) {

    List<Map<String, String>> inputList = null;
    JavascriptExecutor js = (JavascriptExecutor)argDriver;
    inputList = (List<Map<String, String>>) js.executeScript("var result = []; " +
        "var all = document.querySelectorAll('input, select'); " +
        "for (var i=0, max=all.length; i < max; i++) { " +
        "  var checked ='0'; " +
        "  var value = ''; " +
        "  if (all[i].tagName == 'select') {" +
        "    value = all[i].options[all[i].selectedIndex].value; " +
        "  } else { " +
        "    if (all[i].type == 'radio') { " +
        "      if (all[i].checked) { checked = '1'; } else { continue; } " +
        "    } " +
        "    if (all[i].type == 'checkbox') { " +
        "      if (all[i].checked) { checked = '1' } else { continue; } " +
        "    } " +
        "    value = all[i].value; " +
        "  } " +
        "  result.push({'id': all[i].id, 'name': all[i].name, 'type': all[i].type, 'value':value, 'checked':checked}); " +
        "} " +
        " return result; ");
    //js.executeScript(script, args);

    return inputList;
  }
  /**
   *
   * @param driver
   */
  public static void switchToTop(WebDriver driver) {

  }


}
