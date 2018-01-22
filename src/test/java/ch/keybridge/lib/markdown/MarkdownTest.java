/*
 * Copyright 2018 Key Bridge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.keybridge.lib.markdown;

import java.io.*;
import java.nio.charset.Charset;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test fenced code block processing
 *
 * @author Key Bridge
 */
public class MarkdownTest {

  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final String RES = "/testsuite/";

  public MarkdownTest() {
  }

  protected final static String readTextUTF_8(final InputStream in) throws IOException {
    final Reader r = new BufferedReader(new InputStreamReader(in, UTF_8));
    final StringBuilder sb = new StringBuilder();
    try {
      for (;;) {
        final int ch = r.read();
        if (ch > -1) {
          sb.append((char) ch);
        } else {
          break;
        }
      }
      return sb.toString();
    } finally {
      in.close();
    }
  }

  @Test
  public void testFencedCode() throws IOException {

    String name = "Fenced Code Block";

    final InputStream txtIn = ConformityTest.class.getResourceAsStream(RES + name + ".text");
    final InputStream cmpIn = ConformityTest.class.getResourceAsStream(RES + name + ".html");
    if (txtIn == null || cmpIn == null) {
      Assert.fail("Unmatched test resources");
    }

    final String text = readTextUTF_8(txtIn);
    final String compare = readTextUTF_8(cmpIn);

    Configuration.Builder configuration = Configuration.builder();

    final String processed = Markdown.process(text);

    System.out.println(processed);

  }

}
