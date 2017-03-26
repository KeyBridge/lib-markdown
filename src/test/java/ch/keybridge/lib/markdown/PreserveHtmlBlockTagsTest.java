package ch.keybridge.lib.markdown;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PreserveHtmlBlockTagsTest {

  private final Markdown m;
  private final String value;

  @Parameters
  public static Collection<Object[]> testHtml() {
    return Arrays.asList(new Object[][]{
      {"<h1>Chapter One</h1>"},
      {"<H1>Chapter One</H1>"},
      {"<div>\n  <div>Text</div>\n</div>"},
      {"<DIV>\n  <DIV>Text</DIV>\n</DIV>"},
      {"<TABLE>\n<TR>\n<TD>Cell</TD>\n</TR>\n</TABLE>"},
      {"<BlockQuote>All the world’s a stage…</BlockQuote>"},
      {"<iFrame src='http://microsoft.com/'></IFRAME>"},
      {"<hr/>"},
      {"<HR>"},
      {"<!-- a comment -->"}
    });
  }

  public PreserveHtmlBlockTagsTest(String value) {
    this.m = new Markdown();
    this.value = value;
  }

  @Test
  public void testRoundtripPreservesTags() {
    assertEquals(value, m.toHtml(value).trim());
  }

}
