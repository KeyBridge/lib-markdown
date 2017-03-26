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

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Copyright (c) 2005, Pete Bevin. http://markdownj.petebevin.com
 * @author Key Bridge
 */
public class CharacterProtector {

  private final ConcurrentMap<String, String> protectMap = new ConcurrentHashMap<>();
  private final ConcurrentMap<String, String> unprotectMap = new ConcurrentHashMap<>();
  private static final String GOOD_CHARS = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
  private final Random rnd = new Random();

  public String encode(String literal) {
    String encoded = protectMap.get(literal);
    if (encoded == null) {
      synchronized (protectMap) {
        encoded = protectMap.get(literal);
        if (encoded == null) {
          encoded = addToken(literal);
        }
      }
    }
    return encoded;
  }

  public String decode(String coded) {
    return unprotectMap.get(coded);
  }

  public Collection<String> getAllEncodedTokens() {
    return Collections.unmodifiableSet(unprotectMap.keySet());
  }

  private String addToken(String literal) {
    String encoded = longRandomString();

    protectMap.put(literal, encoded);
    unprotectMap.put(encoded, literal);

    return encoded;
  }

  private String longRandomString() {
    StringBuilder sb = new StringBuilder();
    final int CHAR_MAX = GOOD_CHARS.length();
    for (int i = 0; i < 20; i++) {
      sb.append(GOOD_CHARS.charAt(rnd.nextInt(CHAR_MAX)));
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return protectMap.toString();
  }
}
