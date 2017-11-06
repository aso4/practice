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
            // System.out.println("found ATG: " + atg);
            if (s.indexOf("TAA") > atg + 3) {
                taa = s.substring(atg, s.length()).indexOf("TAA") + atg;
                // System.out.println("substring: " + s.substring(atg, s.length()));
                // System.out.println("taa: " + taa);
                // System.out.println("found TAA: " + taa);
                if ((atg + taa) % 3 == 0) {
                    results = s.substring(atg, taa + 3);
                } else {
                    results = "Not a valid string";
                }
            } else {
                results = "No TAA";
            }
        } else {
            results = "No ATG";
        }
        return results;
    }

    public static void main (String[] args) {
        Part1 test = new Part1();
        // test.findSimpleGene("QWERTYATGATAA");
    }

    public void testFindSimpleGene() {
        System.out.println("test 1: " + findSimpleGene("QWERTYATAA"));
        System.out.println("test 2: " + findSimpleGene("QWERTYATGA"));
        System.out.println("test 3: " + findSimpleGene("QWERTYA"));
        System.out.println("test 4: " + findSimpleGene("QWERTYATGATAA"));
        System.out.println("test 5: " + findSimpleGene("QWERTYATGACTATATAA"));
    }
}
