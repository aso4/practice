import edu.duke.*;
import java.io.File;
import java.util.*;

/**
 * Write a description of Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene (String dna, String startCodon, String stopCodon) {
        String results = "";
        int start, stop = 0;
        if (dna.indexOf(startCodon) > 0) {
            start = dna.indexOf(startCodon);
            if (dna.indexOf(stopCodon) > start + 3) {
                stop = dna.substring(start, dna.length()).indexOf(stopCodon) + start;
                if ((start + stop) % 3 == 0) {
                    results = dna.substring(start, stop + 3);
                } else {
                    results = "Not a valid string";
                }
            } else {
                results = "No TAA";
            }
        } else {
            results = "No ATG";
        }
        if (dna.toLowerCase().toCharArray()[0] == dna.toCharArray()[0]) {
            return results.toLowerCase();
        }
        return results.toUpperCase();
    }

    public static void main (String[] args) {
        Part1 test = new Part1();
    }

    public void testSimpleGene() {
        System.out.println("test 1: " + findSimpleGene("QWERTYATAA", "ATG", "TAA"));
        System.out.println("test 2: " + findSimpleGene("QWERTYATGA", "ATG", "TAA"));
        System.out.println("test 3: " + findSimpleGene("QWERTYATGA", "ATG", "TAA"));
        System.out.println("test 4: " + findSimpleGene("QWERTYATGATAA", "ATG", "TAA"));
        System.out.println("test 5: " + findSimpleGene("QWERTYATGACTATATAA", "ATG", "TAA"));
        System.out.println("test 6: " + findSimpleGene("qwertyatgactatataa", "atg", "taa"));
    }
}
