package ch.keybridge.lib.markdown;

public class TestResultPair {

  private final String name;
  private final String test;
  private final String result;

  public TestResultPair(String name, String test, String result) {
    this.name = name;
    this.test = test;
    this.result = result;
  }

  public String getTest() {
    return test;
  }

  public String getResult() {
    return result;
  }

  @Override
  public String toString() {
    return name;
  }
}
