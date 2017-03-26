package ch.keybridge.lib.markdown;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandleHtmlInlineTagsTest {

  private Markdown m;

  @Before
  public void createProcessor() {
    m = new Markdown();
  }

  @Test
  public void testInlineTagsWithMarkdown() {
    assertEquals("<p><span><strong>Something really enjoyable!</strong></span></p>",
                 m.toHtml("<span>**Something really enjoyable!**</span>").trim());
  }

  @Test
  public void testUpperCaseInlineTagsWithMarkdown() {
    assertEquals("<p><SPAN><strong>oh no</strong></SPAN></p>",
                 m.toHtml("<SPAN>**oh no**</SPAN>").trim());
  }

}
