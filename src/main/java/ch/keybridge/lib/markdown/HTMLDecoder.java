/*
 * Copyright (C) Various authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.keybridge.lib.markdown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Copyright (c) 2005, Pete Bevin. http://markdownj.petebevin.com
 * @author Key Bridge
 */
public class HTMLDecoder {

  public static String decode(String html) {
    TextEditor ed = new TextEditor(html);
    Pattern p1 = Pattern.compile("&#(\\d+);");
    ed.replaceAll(p1, (Matcher m) -> {
            String charDecimal = m.group(1);
            char ch = (char) Integer.parseInt(charDecimal);
            return Character.toString(ch);
          });

    Pattern p2 = Pattern.compile("&#x([0-9a-fA-F]+);");
    ed.replaceAll(p2, (Matcher m) -> {
            String charHex = m.group(1);
            char ch = (char) Integer.parseInt(charHex, 16);
            return Character.toString(ch);
          });

    return ed.toString();
  }
}
