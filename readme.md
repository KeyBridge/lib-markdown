# lib-markdown

**Markdown to HTML translation.**

Markdown is a pure Java port of Markdown (a text-to-html conversion tool written by John Gruber.) This library is a fork, upgrade and and rewrite of **MarkdownJ** which ceased development around 2005. 
    
This library supports basic encoded Markdown text. For a very sophisticated and actively
developed MD processor check out flexmark-java.

*Usage*

```java
 Markdown markdown = new Markdown();
 String html = markdown.toHtml("This is *Html*");
```

### License

Licensed under a Revised BSD License. Refer to the accompanying LICENSE file.

The original MarkdownJ project is:

 - Copyright (c) 2005 Pete Bevin
 - Copyright (c) 2005 - 2007 John Mutchek, Marty Lamb / Martian Software, Inc.
 - Copyright (c) 2008 - 2013 Alex Coles

### History

 - v1.0.0 fork of MarkdownJ v0.5.0 snapshot; clean up for JDK8
 - v1.1.0 - add support for github encoded code blocks using three back ticks (```)

### References

 - [Markdown](https://daringfireball.net/projects/markdown)
 - [Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
 
 
