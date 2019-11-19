/*
 * Copyright (C) 2018 Key Bridge
 * Copyright (C) 2011-2015 René Jeschke
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
package ch.keybridge.markdown;

/**
 * Line type enumeration.
 *
 * @author Key Bridge
 * @author René Jeschke
 */
enum LineType {
  /**
   * Empty line.
   */
  EMPTY,
  /**
   * Undefined content.
   */
  OTHER,
  /**
   * A markdown headline.
   */
  HEADLINE,
  HEADLINE1,
  HEADLINE2,
  /**
   * A code block line.
   */
  CODE,
  /**
   * A list.
   */
  ULIST,
  OLIST,
  /**
   * A block quote.
   */
  BQUOTE,
  /**
   * A horizontal ruler.
   */
  HR,
  /**
   * Start of a XML block.
   */
  XML,
  /**
   * Fenced code block start/end
   */
  FENCED_CODE
}
