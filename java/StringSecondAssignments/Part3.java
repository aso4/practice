import edu.duke.*;
import java.io.File;
/**
 * Write a description of Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int temp = dna.indexOf(stopCodon, startIndex);
        if (temp > -1 && (temp - startIndex) % 3 == 0) {
            return temp;
        }
        return dna.length();
    }

    public String findGene(String dna) {
        int atgIndex, taaIndex, tagIndex, tgaIndex;
        atgIndex = taaIndex = tagIndex = tgaIndex = -1;
        if (dna.indexOf("ATG") == -1) {
            return "";
        } else {
            atgIndex = dna.indexOf("ATG");
        }
        if (findStopCodon(dna, atgIndex, "TAA") != dna.length()) {
            taaIndex = findStopCodon(dna, atgIndex, "TAA");
        }
        if (findStopCodon(dna, atgIndex, "TAG") != dna.length()) {
            tagIndex = findStopCodon(dna, atgIndex, "TAG");
        }
        if (findStopCodon(dna, atgIndex, "TGA") != dna.length()) {
            tgaIndex = findStopCodon(dna, atgIndex, "TGA");
        }
        if (atgIndex > -1) {
            if (taaIndex > 0) {
                return dna.substring(atgIndex, taaIndex + 3);
            } else if (tagIndex > 0) {
                return dna.substring(atgIndex, tagIndex + 3);
            } else if (tgaIndex > 0) {
                return dna.substring(atgIndex, tgaIndex + 3);
            }
        }
        return "";
    }
    public void printAllGenes(String dna) {
        while (true) {
            if (findGene(dna).length() != 0) {
                String temp = findGene(dna);
                int tempIndex = dna.indexOf(temp);
                System.out.println(temp);
                dna = dna.substring(tempIndex + temp.length());
            } else {
                break;
            }
        }
    }
    public int countGenes(String dna) {
        int count = 0;
        while (true) {
            if (findGene(dna).length() != 0) {
                String temp = findGene(dna);
                int tempIndex = dna.indexOf(temp);
                count++;
                dna = dna.substring(tempIndex + temp.length());
            } else {
                break;
            }
        }
        return count;
    }
    public void testCountGenes() {
        System.out.println(countGenes("ATGTAAGATGCCCTAGT"));
        System.out.println(countGenes("ATGTAAGATGCCCTAGTATGTAAGATGCCCTAGT"));
    }
}
