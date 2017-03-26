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

/**
 * @author Copyright (c) 2005, Pete Bevin. http://markdownj.petebevin.com
 * @author Key Bridge
 */
public class LinkDefinition {

  private final String url;
  private final String title;

  public LinkDefinition(String url, String title) {
    this.url = url;
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return url + " (" + title + ")";
  }
}
