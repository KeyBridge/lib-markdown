/*
 * Copyright (C) 2015 René Jeschke <rene_jeschke@yahoo.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.keybridge.lib.markdown;

import java.util.List;

public class CodeBlockEmitter implements BlockEmitter {

  private static void append(StringBuilder out, List<String> lines) {
    out.append("<pre class=\"pre_no_hl\">");
    for (final String l : lines) {
      Utils.escapedAdd(out, l);
      out.append('\n');
    }
    out.append("</pre>");
  }

  @Override
  public void emitBlock(StringBuilder out, List<String> lines, String meta) {
    append(out, lines);

//    if (meta != null && !meta.isEmpty()) {
//      append(out, lines);
//    } else {
//      try {
//        // Utils#highlight(...) is not included with txtmark, it's sole purpose
//        // is to show what the meta can be used for
//        out.append(Utils.highlight(lines, meta));
//        out.append('\n');
//      } catch (final IOException e) {
//        // Ignore or do something, still, pump out the lines
//        append(out, lines);
//      }
//    }
  }
}
