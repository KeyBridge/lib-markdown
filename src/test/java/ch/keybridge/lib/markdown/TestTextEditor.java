package ch.keybridge.lib.markdown;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTextEditor {

  @Test
  public void testDetabify() {
    assertEquals("    ", new TextEditor("\t").detabify().toString());
    assertEquals("    ", new TextEditor(" \t").detabify().toString());
    assertEquals("    ", new TextEditor("  \t").detabify().toString());
    assertEquals("    ", new TextEditor("   \t").detabify().toString());
    assertEquals("        ", new TextEditor("    \t").detabify().toString());

    assertEquals("     ", new TextEditor("\t ").detabify().toString());
    assertEquals("        ", new TextEditor("\t \t").detabify().toString());
  }

}
