package ch.keybridge.lib.markdown;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineConventions {

  private static final String EXPECTED = "<p>a\nb\nc</p>\n";
  private Markdown m;

  @Before
  public void createProcessor() {
    m = new Markdown();
  }

  @Test
  public void testUnixLineConventions() {
    assertEquals(EXPECTED, m.toHtml("a\nb\nc\n"));
  }

  @Test
  public void testWindowsLineConventions() {
    Markdown markup = new Markdown();
    assertEquals(EXPECTED, markup.toHtml("a\r\nb\r\nc\r\n"));
  }

  @Test
  public void testMacLineConventions() {
    Markdown markup = new Markdown();
    assertEquals(EXPECTED, markup.toHtml("a\rb\rc\r"));
  }
}
