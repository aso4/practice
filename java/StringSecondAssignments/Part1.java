
/**
 * Write a description of Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int temp = dna.indexOf(stopCodon, startIndex);
        if (temp > -1 && (temp - startIndex) % 3 == 0) {
            // System.out.println("multiple of 3");
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
            // System.out.println("gene found");
        }
        // System.out.println(atgIndex + " " + taaIndex + " " + tagIndex + " " + tgaIndex);
        return "";
    }

    public void testFindStopCodon() {
        System.out.println(findStopCodon("ATGCAATAA", 0, "TAA"));
        System.out.println(findStopCodon("TAATGGCAATAA", 2, "TAA"));
        System.out.println(findStopCodon("TAAATGCAAGTGCA", 3, "TAA"));
    }

    public void testFindGene() {
        System.out.println(findGene("ATGTATTAA"));
        System.out.println(findGene("ATGTATTAG") + " TAG working");
        System.out.println(findGene("ATGTATTGA") + " TGA working");
        System.out.println(findGene("AAATGTATTGA") + " AA subtracted");
        System.out.println(findGene("AGTATGTGATTGA") + " start and stop codons only");
        System.out.println(findGene("TAATGTATTAA") + " TAA subtracted");
        System.out.println(findGene("GTATTAAGTGA") + " not a valid gene");
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
            System.out.println("remaining dna: " + dna);
        }
    }

    public void testPrintAllGenes() {
        printAllGenes("ATGTATTAGATGTATTAGATGTATTAG");
    }
}
