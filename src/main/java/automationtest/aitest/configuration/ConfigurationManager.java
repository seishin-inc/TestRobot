package automationtest.aitest.configuration;

public class ConfigurationManager {

  private final Configuration conf = null;

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
