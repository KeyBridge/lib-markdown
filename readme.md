# lib-markdown

Markdown is a pure Java port of Markdown (a text-to-html conversion tool written by John Gruber.)
This library is a fork, upgrade and and rewrite of MarkdownJ which ceased development around 2005.
This library supports basic encoded Markdown text. For a very sophisticated and actively
developed MD processor check out flexmark-java.

*Usage*

```java
 Markdown markdown = new Markdown();
 String html = markdown.toHtml("This is *Html*");
```

## License

The project is licensed under a Revised BSD License. Refer to the accompanying LICENSE file.
