# lib-markdown

**Markdown to HTML translation.**

Markdown is a pure Java port of Markdown (a text-to-html conversion tool written by John Gruber.) This library is a fork, upgrade and and rewrite of **MarkdownJ** which ceased development around 2005.
MarkdownJ uses a sophisticated REGEX and pattern substitution strategy. It requires a deep understanding of Java Patterns to maintain.

This library supports basic encoded Markdown text. We use it to render simple encoded
text blocks in various languages.

Version 1 of this library is a fork and rewrite of MarkdownJ, which
ceased development around 2005 (excepting minor patches).

  Original project MarkdownJ is:
  Copyright (c) 2005 Pete Bevin
  Copyright (c) 2005 - 2007 John Mutchek, Marty Lamb / Martian Software, Inc.
  Copyright (c) 2008 - 2013 Alex Coles

Version 2 of this library is a fork and rewrite of **Txtmark**, a slightly faster MD processor which ceased development around 2015. Txtmark employs
a scanner-based approach using a recursive text block marking strategy to identify and reformat recognized blocks of text.

  Original project Txtmark is:
  Copyright (C) 2011-2015 René Jeschke rene_jeschke@yahoo.de


### Usage

Version 2:


```java
   String html = Markdown.process("This is *Markdown*");
```

Version 1 (**deprecated**)


```java
  Markdown markdown = new Markdown();
  String html = markdown.toHtml("This is *Markdown*");
```


### Fenced code blocks and pretty print

This library outputs fenced code blocks compatible with HTML5 code display.

e.g.

<code>```java ... </code> is translated to

```html
<pre><code class="java">...</code></pre>
```

To pretty print software code blocks we recommend the [highlight.js](http://highlightjs.org/)
javascript syntax highlighting library.


### History

  v1.0.0 fork of MarkdownJ v0.5.0 snapshot; clean up for JDK8
  v1.1.0 - add support for fenced code blocks using three back ticks (```)
  v2.0.0 - fork to code based upon Txtmark project; fix fenced code block processing


### License

Licensed under a Revised BSD License. Refer to the accompanying LICENSE file.



### References

For a more sophisticated and actively developed (but huge and complicated) MD processor check out flexmark-java.

 - [Markdown](https://daringfireball.net/projects/markdown)
 - [Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
 - [flexmark-java](https://github.com/vsch/flexmark-java)

