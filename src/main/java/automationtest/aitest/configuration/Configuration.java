package automationtest.aitest.configuration;

public class Configuration {

  private long explicityWaitSeconds = 0;
  private long implicityWaitMilliseconds = 0;
  private long maxRetryWaitMilliseconds = 0;
  private long retryIntervalMilliseonds = 0;

  public long getExplicityWaitSeconds() {
    return explicityWaitSeconds;
  }

  public void setExplicityWaitSeconds(long value) {
    this.explicityWaitSeconds = value;
  }

  public long getImplicityWaitMilliseconds() {
    return implicityWaitMilliseconds;
  }

  public void setImplicityWaitMilliseconds(long value) {
    this.implicityWaitMilliseconds = value;
  }

  public long getMaxRetryWaitMilliseconds() {
    return maxRetryWaitMilliseconds;
  }

  public void setMaxRetryWaitMilliseconds(long value) {
    this.maxRetryWaitMilliseconds = value;
  }

  public long getRetryIntervalMilliseonds() {
    return retryIntervalMilliseonds;
  }

  public void setRetryIntervalMilliseonds(long value) {
    this.retryIntervalMilliseonds = value;
  }

}
