package ch.keybridge.lib.markdown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class MarkupFileTester {

  private final static String[] TEST_FILENAMES = new String[]{
    "/dingus.txt",
    "/paragraphs.txt",
    "/snippets.txt",
    "/lists.txt"
  };

  TestResultPair pair;

  @Parameters
  public static Collection<Object[]> testResultPairs() throws IOException {
    List<TestResultPair> fullResultPairList = new ArrayList<>();
    for (String filename : TEST_FILENAMES) {
      fullResultPairList.addAll(newTestResultPairList(filename));
    }

    Collection<Object[]> testResultPairs = new ArrayList<>();
    for (TestResultPair p : fullResultPairList) {
      testResultPairs.add(new Object[]{p});
    }
    return testResultPairs;
  }

  public MarkupFileTester(TestResultPair pair) {
    this.pair = pair;
  }

  public static List<TestResultPair> newTestResultPairList(String filename) throws IOException {
    List<TestResultPair> list = new ArrayList<>();
    URL fileUrl = MarkupFileTester.class.getResource(filename);
    File file;
    try {
      file = new File(fileUrl.toURI());
    } catch (URISyntaxException e) {
      file = new File(fileUrl.getFile());
    }
    FileReader fileReader = new FileReader(file);
    BufferedReader in = new BufferedReader(fileReader);
    StringBuilder test = null;
    StringBuilder result = null;

    Pattern pTest = Pattern.compile("# Test (\\w+) \\((.*)\\)");
    Pattern pResult = Pattern.compile("# Result (\\w+)");
    String line;
    int lineNumber = 0;

    String testNumber = null;
    String testName = null;
    StringBuilder curbuf = null;
    while ((line = in.readLine()) != null) {
      lineNumber++;
      Matcher mTest = pTest.matcher(line);
      Matcher mResult = pResult.matcher(line);

      if (mTest.matches()) { // # Test
        addTestResultPair(list, test, result, testNumber, testName);
        testNumber = mTest.group(1);
        testName = mTest.group(2);
        test = new StringBuilder();
        result = new StringBuilder();
        curbuf = test;
      } else if (mResult.matches()) { // # Result
        if (testNumber == null) {
          throw new RuntimeException("Test file has result without a test (line " + lineNumber + ")");
        }
        String resultNumber = mResult.group(1);
        if (!testNumber.equals(resultNumber)) {
          throw new RuntimeException("Result " + resultNumber + " test " + testNumber + " (line " + lineNumber + ")");
        }

        curbuf = result;
      } else {
        curbuf.append(line);
        curbuf.append("\n");
      }
    }

    addTestResultPair(list, test, result, testNumber, testName);

    return list;
  }

  private static void addTestResultPair(List list, StringBuilder testbuf, StringBuilder resultbuf, String testNumber, String testName) {
    if (testbuf == null || resultbuf == null) {
      return;
    }

    String test = chomp(testbuf.toString());
    String result = chomp(resultbuf.toString());

    String id = testNumber + "(" + testName + ")";

    list.add(new TestResultPair(id, test, result));
  }

  private static String chomp(String s) {
    int lastPos = s.length() - 1;
    while (s.charAt(lastPos) == '\n' || s.charAt(lastPos) == '\r') {
      lastPos--;
    }
    return s.substring(0, lastPos + 1);
  }

  @Test
  public void runTest() {
    Markdown markup = new Markdown();
    assertEquals(pair.toString(), pair.getResult().trim(), markup.toHtml(pair.getTest()).trim());
  }
}
