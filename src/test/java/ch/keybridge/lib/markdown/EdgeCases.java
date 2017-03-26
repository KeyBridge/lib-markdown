package ch.keybridge.lib.markdown;

import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EdgeCases {

  private Markdown m;

  @Before
  public void createProcessor() {
    m = new Markdown();
  }

  @Test
  public void testEmptyString() {
    assertEquals("\n", m.toHtml(""));
  }

  @Test
  public void testSpaces() {
    assertEquals("\n", m.toHtml("  "));
  }

  @Test
  public void testNull() {
    assertEquals("\n", m.toHtml(null));
  }

  @Test
  public void testSplitAssumption() {
    // In Perl, split(/x/, "") returns the empty string.
    // But in Java, it's the array { "" }.
    Pattern x = Pattern.compile("x");
    String[] xs = x.split("");
    assertEquals(1, xs.length);
    assertEquals("", xs[0]);
  }
}
