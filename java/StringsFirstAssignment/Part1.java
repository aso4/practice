import edu.duke.*;
import java.io.File;
import java.util.*;

/**
 * Write a description of Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene (String s) {
        String results = "";
        int atg, taa = 0;
        if (s.indexOf("ATG") > 0) {
            atg = s.indexOf("ATG");
            System.out.println("found ATG: " + atg);
            if (s.indexOf("TAA") > atg + 3) {
                taa = s.substring(atg, s.length()).indexOf("TAA");
                System.out.println("substring: " + s.substring(atg, s.length()));
                // System.out.println("found TAA: " + taa);
                if ((atg + taa) % 3 == 0) {
                    results = s.substring(atg, taa);
                }
            }
        }
        return results;
    }

    public static void main (String[] args) {
        Part1 test = new Part1();
        // test.findSimpleGene("QWERTYATGATAA");
    }

    public void testFindSimpleGene() {
        findSimpleGene("QWERTYATGATAA");
    }
}
