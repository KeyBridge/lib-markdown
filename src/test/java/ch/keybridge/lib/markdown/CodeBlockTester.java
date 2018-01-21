package ch.keybridge.lib.markdown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;

public class CodeBlockTester {

  private Markdown m;

  @Before
  public void createProcessor() {
    m = new Markdown();
  }

  @Test
  public void testInlineCode() {
    String text = "affert tantas ubique `dolorum` libero tacimates pericula";
    System.out.println(m.toHtml(text));
  }

  @Test
  public void testCodeBlock() {
    String text = "definitiones fringilla sadipscing a mus mandamus "
      + "dapibus instructior scripserit mel unum conclusionemque signiferumque urbanitas \n"
      + "``` java\n"
      + "elit fringilla laudem recteque \n"
      + "vehicula inani signiferumque tempus interpretaris \n"
      + "nullam vidisse lacus dicta sodales \n"
      + "causae ceteros oporteat erat definitionem \n"
      + "reformidans constituam affert tantas \n"
      + "ubique dolorum libero tacimates pericula \n"
      + "oratio minim interpretaris eripuit \n"
      + "alia vivendo hendrerit brute senserit rutrum \n"
      + "```\n"
      + "audire voluptatum tamquam eloquentiam appareat putent sem fastidii hendrerit "
      + "prodesset feugait lacus **offendit** maiestatis fringilla pericula quem noster "
      + "adipisci splendide quidam aptent _facilisis_ constituto \n\n"
      + "  - molestie \n"
      + "  - magnis \n"
      + "  - quaeque \n\n"
      + "augue auctor adipiscing aliquid tacimates proin minim melius ex error "
      + "instructior mea prompta adipisci";

    String pattern;

//    pattern = "(?:[`]{3})(.+?)(?=[`]{3})";
//    pattern = "(\n```(\\w*))(.*)";
//    pattern = "(?<=\\s```)(\\w*)\\n((.*\\n?)+)";
//    pattern = "(?<=```)((\\w*)\\n((.*\\n)+)(?=```))"; // captures with look behind look ahead but does not include back ticks
//    pattern = "(?:```)\\s?+(\\w*)\\n((.*\\n)+)(?:```)"; // works! non capturing groups = final pattern; fails without language
    pattern = "(?:```)[\\s]*([\\w]*)?\\n((.*\\n)+)(?:```)"; // 01/21/18 works! with or without language

    Pattern p = Pattern.compile(pattern);

    Matcher matcher = p.matcher(text);
    if (matcher.find()) {
      System.out.println(" found ");
      for (int i = 0; i < matcher.groupCount(); i++) {
        System.out.println(i + " " + matcher.group(i));
      }
    }

//    System.out.println(m.toHtml(text));
  }

}
