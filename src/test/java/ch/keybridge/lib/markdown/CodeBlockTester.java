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
    String lorem = "definitiones fringilla sadipscing a mus mandamus "
      + "dapibus instructior scripserit mel unum conclusionemque signiferumque urbanitas \n"
      + "```java\n"
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

    String codeblock = "media to deliver and display the content for the same. Also, the word publisher can refer to the individual who leads a publishing company or an imprint or to a person who owns/heads a magazine.\n"
      + "```java\n"
      + "  public void onEditReadme() {\n"
      + "    if (FacesUtil.getRequestParameter(\"readme\") != null) {\n"
      + "      ticketableBean.getTicketable().setReadme(FacesUtil.getRequestParameter(\"readme\"));\n"
      + "      ticketableBean.onEditEntity();\n"
      + "    }\n"
      + "    this.editing = false;\n"
      + "  }\n"
      + "```\n"
      + "\n"
      + "FOO\n"
      + "\n"
      + "FOO\n"
      + "```xml\n"
      + "+---------------------+\n"
      + "| Tables_in_test      |\n"
      + "+---------------------+\n"
      + "| attachment          |\n"
      + "| milestone           |\n"
      + "| ticket              |\n"
      + "| ticket_assignees    |\n"
      + "| ticket_blockers     |\n"
      + "| ticket_entry        |\n"
      + "| ticket_watchers     |\n"
      + "| ticketable          |\n"
      + "| ticketable_roles    |\n"
      + "| ticketable_watchers |\n"
      + "+---------------------+\n"
      + "```\n"
      + "\n"
      + "Warning:   StandardSession: Cannot serialize session attribute WELD_S#WELD%ManagedBean%ticketroller-ear-0.2.0.bda|ticketrolle\n"
      + "Severe:   Exception while visiting ticketroller-web-0.2.0_war/WEB-INF/classes/ch/keybridge/tr/jsf/t/TrReadmeEditorBean.class of size 0";

    String pattern;

//    pattern = "(?:[`]{3})(.+?)(?=[`]{3})";
//    pattern = "(\n```(\\w*))(.*)";
//    pattern = "(?<=\\s```)(\\w*)\\n((.*\\n?)+)";
//    pattern = "(?<=```)((\\w*)\\n((.*\\n)+)(?=```))"; // captures with look behind look ahead but does not include back ticks
//    pattern = "(?:```)\\s?+(\\w*)\\n((.*\\n)+)(?:```)"; // works! non capturing groups = final pattern; fails without language
//    pattern = "(?:```)[\\s]*([\\w]*)?\\n((.*\\n)+)(?:```)"; // 01/21/18 works on one with or without language
    pattern = "(?:```)[\\s]*([\\w]*)?\\n((.*\\n)+)(?:```)"; // 01/21/18 works on one with or without language

//    Pattern p = Pattern.compile(pattern, Pattern.MULTILINE);
    Pattern p = Pattern.compile("(?:\\n\\n|\\A)" + "((?:" + "(?:[`]{3})" + ".*\\n+" + ")+" + ")" + "((?=\\S)|\\Z)", Pattern.MULTILINE);

    Matcher matcher = p.matcher(codeblock);
    if (matcher.find()) {
      System.out.println(" found ");
      for (int i = 0; i < matcher.groupCount(); i++) {
        System.out.println(i + " " + matcher.group(i));
      }
    }

//  Pattern p = Pattern.compile("(?:\\n\\n|\\A)" + "((?:" + "(?:[ ]{4})" + ".*\\n+" + ")+" + ")" + "((?=^[ ]{0,4}\\S)|\\Z)", Pattern.MULTILINE);
//    System.out.println(m.toHtml(text));
  }

}
