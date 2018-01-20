# lib-markdown

**Markdown to HTML translation.**

Markdown is a pure Java port of Markdown (a text-to-html conversion tool written by John Gruber.) This library is a fork, upgrade and and rewrite of **MarkdownJ** which ceased development around 2005. 
    
This library supports basic encoded Markdown text. We use it to render simple encoded
text blocks in various languages.

*Usage*

```java
 Markdown markdown = new Markdown();
 String html = markdown.toHtml("This is *Html*");
```

### License

Licensed under a Revised BSD License. Refer to the accompanying LICENSE file.

 - Copyright (c) 2005 Pete Bevin 
 - Copyright (c) 2005 - 2007 John Mutchek, Marty Lamb / Martian Software, Inc.
 - Copyright (c) 2008 - 2013 Alex Coles
 - Copyright (c) 2017+ Key Bridge 

### History

 - v1.0.0 fork of MarkdownJ v0.5.0 snapshot; clean up for JDK8
 - v1.1.0 - add support for github encoded code blocks using three back ticks (```)

### References

For a more sophisticated and actively developed MD processor check out flexmark-java.

 - [Markdown](https://daringfireball.net/projects/markdown)
 - [Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
 - [flexmark-java](https://github.com/vsch/flexmark-java)
 
 
