import edu.duke.*;
import java.io.File;

/**
 * Write a description of Part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part4 {
    public void StringsFirstAssignments(String webpage) {
        URLResource resource = new URLResource(webpage);

        for (String word : resource.words()) {
            if (word.contains("youtube.com")) {
                int startQuote = word.indexOf("\"");
                int endQuote = word.indexOf("\"", startQuote + 1);
                System.out.println(startQuote + ", " + endQuote + ", " + word);
                System.out.println(word.substring(startQuote + 1, endQuote));
            }

        }
    }

    public void test(){
        StringsFirstAssignments("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
}
