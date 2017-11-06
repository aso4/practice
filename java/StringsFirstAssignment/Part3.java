import edu.duke.*;
import java.io.File;

/**
 * Write a description of Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences (String stringa, String stringb) {
        boolean result;
        int sum = 0;
        System.out.println("stringb.indexOf(stringa): " + stringb.indexOf(stringa));
        // System.out.println("check: " + new String("abctesttest").indexOf(new String("test")));
        if (stringb.indexOf(stringa) > -1) {
            int index = stringb.indexOf(stringa);
            while (stringb.indexOf(stringa) > -1) {
                stringb = stringb.substring(index + stringa.length(), stringb.length());
                System.out.println(stringb);
                sum += 1;
            }
        }

        if (sum > 1) {
            return true;
        }
        System.out.println("sum: " + sum);
        return false;
    }

    public static void main (String[] args) {
        Part3 test = new Part3();
    }

    public void testing() {
        System.out.println("test 1: " + twoOccurrences("QW","ABCQWERTQWTAA"));
        System.out.println("test 2: " + twoOccurrences("a", "banana"));
        System.out.println("test 3: " + twoOccurrences("atg", "ctgtatgta"));
        //System.out.println("test 4: " + twoOccurrences("QWERTYATGATAA","QW"));
        //System.out.println("test 5: " + twoOccurrences("QWERTYATGACTATATAA","QW"));
    }
}
