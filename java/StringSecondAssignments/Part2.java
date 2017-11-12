import edu.duke.*;
import java.io.File;
/**
 * Write a description of Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb) {
        int result = 0;
        while (true) {
            if (stringb.indexOf(stringa) > -1) {
                int temp = stringb.indexOf(stringa);
                // System.out.println(temp);
                result++;
                stringb = stringb.substring(temp + stringa.length());
                // System.out.println(stringb);
            } else {
                break;
            }
            // System.out.println("stringb: " + stringb);
        }
        return result;
    }
    public void testHowMany() {
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
    }
}
