package automationtest.aitest.configuration;

public class ConfigurationManager {

  private final Configuration conf = new Configuration();

  private ConfigurationManager() {

  }

  private static ConfigurationManager confMgr = new ConfigurationManager();

  public static  ConfigurationManager getInstance() {
    return confMgr;
  }

  public Configuration getConf() {
    return conf;
  }

}
