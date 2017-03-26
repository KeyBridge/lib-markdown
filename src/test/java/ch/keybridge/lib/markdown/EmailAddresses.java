package ch.keybridge.lib.markdown;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EmailAddresses {

  Markdown m;

  @Before
  public void createProcessor() {
    m = new Markdown();
  }

  @Test
  public void testDecoder() {
    String encoded = "&#98;&#105;&#x6C;&#x6C;&#x67;&#64;&#x6D;i&#x63;&#x72;&#x6F;&#115;&#x6F;&#x66;&#116;&#x2E;c&#111;&#109;";
    String billg = "billg@microsoft.com";

    assertEquals(billg, HTMLDecoder.decode(encoded));
    assertEquals("", HTMLDecoder.decode(""));
  }

  @Test
  public void testEmail() {
    String html = m.toHtml("<billg@microsoft.com>");
    String plain = HTMLDecoder.decode(html);
    assertEquals("<p><a href=\"mailto:billg@microsoft.com\">billg@microsoft.com</a></p>\n", plain);
    assertFalse("Email addresses are masked", plain.equals(html));
  }
}
