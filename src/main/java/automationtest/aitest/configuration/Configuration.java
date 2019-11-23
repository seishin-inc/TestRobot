package automationtest.aitest.configuration;

public class Configuration {

  private long explicityWaitMilliseconds;
  private long implicityWaitMilliseconds;
  private long maxRetryWaitMilliseconds;
  private long retryIntervalMilliseonds;

  public long getExplicityWaitMilliseconds() {
    return explicityWaitMilliseconds;
  }

  public void setExplicityWaitMilliseconds(long value) {
    this.explicityWaitMilliseconds = value;
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
