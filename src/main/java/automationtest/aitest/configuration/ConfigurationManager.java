package automationtest.aitest.configuration;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigurationManager {

  protected static final Logger logger =  LoggerFactory.getLogger(ConfigurationManager.class);

  private static final String CONF_FILE_STRING = "settings.json";
  private Configuration conf = new Configuration();
  private static ConfigurationManager confMgr = new ConfigurationManager();

  private ConfigurationManager() {

    ObjectMapper mapper = new ObjectMapper();
    try (InputStream inputStream = getClass().getClassLoader()
        .getResourceAsStream(CONF_FILE_STRING)) {
      conf = mapper.readValue(inputStream, Configuration.class);
    } catch (Exception e) {
      logger.warn("設定ファイルの読込が失敗しました。{}", e.getMessage());
    }
  }

  public static ConfigurationManager getInstance() {
    return confMgr;
  }

  /**
   * 設定ファイル実例の取得
   * @return
   */
  public Configuration getConf() {
    return conf;
  }

  /**
   * 設定内容の取得
   */
  @Override
  public String toString() {

    String json = "";
    ObjectMapper mapper = new ObjectMapper();
    try {
       json = mapper.writeValueAsString(conf);
    } catch (JsonProcessingException e) {
      // TODO 自動生成された catch ブロック
      logger.warn("設定ファイルの出力が失敗しました。{}", e.getMessage());
    }
    return json;
  }

}
