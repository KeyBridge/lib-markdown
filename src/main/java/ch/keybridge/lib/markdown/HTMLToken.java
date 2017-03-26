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

public class HTMLToken {

  private final boolean isTag;
  private final String text;

  private HTMLToken(boolean tag, String value) {
    isTag = tag;
    text = value;
  }

  public static HTMLToken tag(String text) {
    return new HTMLToken(true, text);
  }

  public static HTMLToken text(String text) {
    return new HTMLToken(false, text);
  }

  /**
   * @return <code>true</code> if this is a tag, <code>false</code> if it's
   *         text.
   */
  public boolean isTag() {
    return isTag;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    String type;
    if (isTag()) {
      type = "tag";
    } else {
      type = "text";
    }
    return type + ": " + getText();
  }
}
