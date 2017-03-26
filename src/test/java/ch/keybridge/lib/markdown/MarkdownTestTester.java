package ch.keybridge.lib.markdown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class MarkdownTestTester {

  private final static String MARKDOWN_TEST_DIR = "/MarkdownTest";

  String test;
  String dir;

  @Parameters(name = "{index}: {1}")
  public static Collection<Object[]> markdownTests() {
    List list = new ArrayList<>();
    URL fileUrl = MarkdownTestTester.class.getResource(MARKDOWN_TEST_DIR);
    File dir;
    try {
      dir = new File(fileUrl.toURI());
    } catch (URISyntaxException e) {
      dir = new File(fileUrl.getFile());
    }
    File[] dirEntries = dir.listFiles();

    for (int i = 0; i < dirEntries.length; i++) {
      File dirEntry = dirEntries[i];
      String fileName = dirEntry.getName();
      if (fileName.endsWith(".text")) {
        String testName = fileName.substring(0, fileName.lastIndexOf('.'));
        list.add(new Object[]{MARKDOWN_TEST_DIR, testName});
      }
    }

    return list;
  }

  public MarkdownTestTester(String dir, String test) {
    this.test = test;
    this.dir = dir;
  }

  @Test
  public void runTest() throws IOException {
    String testText = slurp(dir + File.separator + test + ".text");
    String htmlText = slurp(dir + File.separator + test + ".html");
    Markdown markup = new Markdown();
    String markdownText = markup.toHtml(testText);
    assertEquals(test, htmlText.trim(), markdownText.trim());
  }

  private String slurp(String fileName) throws IOException {
    URL fileUrl = this.getClass().getResource(fileName);
    File file = new File(URLDecoder.decode(fileUrl.getFile(), "UTF-8"));
    BufferedReader in = new BufferedReader(new FileReader(file));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = in.readLine()) != null) {
      sb.append(line).append("\n");
    }
    in.close();
    return sb.toString();
  }
}
