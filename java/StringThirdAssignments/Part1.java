import edu.duke.*;
import java.io.File;
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
        // System.out.println("temp - startIndex: " + (temp-startIndex));
        return dna.length();
    }

    public String findGene(String dna) {
        int atgIndex, taaIndex, tagIndex, tgaIndex;
        dna = dna.toUpperCase();
        atgIndex = taaIndex = tagIndex = tgaIndex = -1;
        if (dna.indexOf("ATG") == -1) {
            return "";
        } else {
            atgIndex = dna.indexOf("ATG");
            int temp = atgIndex;
            while(true) {
                if (findStopCodon(dna, temp, "TAA") != dna.length() ||
                findStopCodon(dna, temp, "TAG") != dna.length() ||
                findStopCodon(dna, temp, "TGA") != dna.length()) {
                    System.out.println("found");
                } else if (temp > dna.length()) {
                    break;
                }
                temp++;
            }
            System.out.println("atgIndex");
            if (findStopCodon(dna, atgIndex, "TAA") != dna.length()) {
                System.out.println(findStopCodon(dna, atgIndex, "TAA"));
                taaIndex = findStopCodon(dna, atgIndex, "TAA");
            }
            // System.out.println("taaIndex: " + taaIndex);
            if (findStopCodon(dna, atgIndex, "TAG") != dna.length()) {
                System.out.println(findStopCodon(dna, atgIndex, "TAG"));
                tagIndex = findStopCodon(dna, atgIndex, "TAG");
            }
            // System.out.println("tagindex: " + tagIndex);
            if (findStopCodon(dna, atgIndex, "TGA") != dna.length()) {
                System.out.println(findStopCodon(dna, atgIndex, "TGA"));
                tgaIndex = findStopCodon(dna, atgIndex, "TGA");
            }
        }
        // System.out.println("atgindex: " + atgIndex);

        // System.out.println("tgaIndex: " + tgaIndex);
        if (atgIndex > -1) {
            if (taaIndex > -1) {
                return dna.substring(atgIndex, taaIndex + 3);
            } else if (tagIndex > -1) {
                return dna.substring(atgIndex, tagIndex + 3);
            } else if (tgaIndex > -1) {
                return dna.substring(atgIndex, tgaIndex + 3);
            }
            // System.out.println("gene found");
        }
        System.out.println(atgIndex + " " + taaIndex + " " + tagIndex + " " + tgaIndex);
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

    public StorageResource getAllGenes(String dna) {
        StorageResource sr = new StorageResource();

        while (true) {
            System.out.println("getallgenes");
            if (findGene(dna).length() != 0) {
                String temp = findGene(dna);
                int tempIndex = dna.indexOf(temp);
                sr.add(temp);
                dna = dna.substring(tempIndex + temp.length());
                System.out.println("dna remaining: " + dna);
            } else {
                break;
            }
            // System.out.println("remaining dna: " + dna);
        }

        return sr;
    }

    public void testPrintAllGenes() {
        printAllGenes("ATGTATTAGATGTATTAGATGTATTAG");
        printAllGenes(new String("atgcctattggatccaaagagaggccaacattttttgaaatttttaa").toUpperCase());
        System.out.println(new String("atgcctattggatccaaagagaggccaacattttttgaaatttttaa").length());
        System.out.println(new String("atgcctattggatccaaagagaggccaacattttttga").length());
    }

    public void testGetAllGenes() {
        System.out.println(getAllGenes("ATGTATTAGATGTATTAGATGTATTAG"));
        for (String gene : getAllGenes("ATGTATTAGATGTATTAGATGTATTAG").data()) {
            System.out.println(gene);
        }
    }

    public float cgRatio(String dna) {
        float result = 0;
        int c = 0;
        int g = 0;
        String[] dnaArray = dna.split("");

        for (int i = 0; i < dnaArray.length; i++) {
            // System.out.println(dnaArray[i]);
            if (dnaArray[i].toUpperCase().equals("C")) {
                c++;
            } else if (dnaArray[i].toUpperCase().equals("G")) {
                g++;
            }
        }
        System.out.println("c: " + c + ". g: " + g);
        result = (float) c/(float) g;
        return result;
    }

    public void testCgRatio() {
        System.out.println(cgRatio("ATGCCATAGGGGGGGGCC"));
    }

    public int countCTG(String dna) {
        int count = 0;
        while (true) {
            if (dna.indexOf("CTG") > -1) {
                count++;
                dna = dna.substring(dna.indexOf("CTG") + 3);
            } else {
                break;
            }
        }
        return count;
    }

    public void processGenes(StorageResource sr) {
        int count = 0;
        int cgRatioCount = 0;
        String longestGene = "";
        for (String s : sr.data()) {
            if (s.length() > 60) {
                System.out.println(s);
                count++;
            }
            if (cgRatio(s) > 0.35) {
                System.out.println(s);
                cgRatioCount++;
            }
            if (s.length() > longestGene.length()) {
                longestGene = s;
            }
        }
        System.out.println("count > 60: " + count);
        System.out.println("longest gene: " + longestGene);
    }

    public void testProcessGenes() {
        /* StorageResource test1 = new StorageResource();
        test1.add("dnasample");
        processGenes(test1);
        test1 = new StorageResource();
        test1.add("dnasample");
        processGenes(test1);
        test1 = new StorageResource();
        test1.add("dnasample");
        processGenes(test1);
        test1 = new StorageResource();
        test1.add("dnasample");
        processGenes(test1);
        test1 = new StorageResource();
        test1.add("dnasample");
        processGenes(test1);    */
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString().toUpperCase();
        // StorageResource genes = getAllGenes(dna); // new StorageResource();

        // System.out.println(dna);
        System.out.println(findGene(new String("acaagtttgtacaaaaaagcagaagggccgtcaaggcccaccatgcctattggatccaaagagaggccaacattttttgaaatttttaagacacgctgcaacaaagcagatttaggaccaataagtcttaattggtttgaagaactttcttcagaagctccaccctataattctgaacctgcagaagaatctgaacataaaaacaacaattacgaaccaaacctatttaaaactccacaaaggaaaccatcttataatcagctggcttcaactccaataatattcaaagagcaagggctgactctgccgctgtaccaatctcctgtaaaagaattagataaattcaaattagacttaggaaggaatgttcccaatagtagacataaaagtcttcgcacagtgaaaactaaaatggatcaagcagatgatgtttcctgtccacttctaaattcttgtcttagtgaaagtcctgttgttctacaatgtacacatgtaacaccacaaagagataagtcagtggtatgtgggagtttgtttcatacaccaaagtttgtgaagggtcgtcagacaccaaaacatatttctgaaagtctaggagctgaggtggatcctgatatgtcttggtcaagttctttagctacaccacccacccttagttctactgtgctcatagtcagaaatgaagaagcatctgaaactgtatttcctcatgatactactgctaatgtgaaaagctatttttccaatcatgatgaaagtctgaagaaaaatgatagatttatcgcttctgtgacagacagtgaaaacacaaatcaaagagaagctgcaagtcatggatttggaaaaacatcagggaattcatttaaagtaaatagctgcaaagaccacattggaaagtcaatgccaaatgtcctagaagatgaagtatatgaaacagttgtagatacctctgaagaagatagtttttcattatgtttttctaaatgtagaacaaaaaatctacaaaaagtaagaactagcaagactaggaaaaaaattttccatgaagcaaacgctgatgaatgtgaaaaatctaaaaaccaagtgaaagaaaaatactcatttgtatctgaagtggaaccaaatgatactgatccattagattcaaatgtagcaaatcagaagccctttgagagtggaagtgacaaaatctccaaggaagttgtaccgtctttggcctgtgaatggtctcaactaaccctttcaggtctaaatggagcccagatggagaaaatacccctattgcatatttcttcatgtgaccaaaatatttcagaaaaagacctattagacacagagaacaaaagaaagaaagattttcttacttcagagaattctttgccacgtatttctagcctaccaaaatcagagaagccattaaatgaggaaacagtggtaaataagagagatgaagagcagcatcttgaatctcatacagactgcattcttgcagtaaagcaggcaatatctggaacttctccagtggcttcttcatttcagggtatcaaaaagtctatattcagaataagagaatcacctaaagagactttcaatgcaagtttttcaggtcatatgactgatccaaactttaaaaaagaaactgaagcctctgaaagtggactggaaatacatactgtttgctcacagaaggaggactccttatgtccaaatttaattgataatggaagctggccagccaccaccacacagaattctgtagctttgaagaatgcaggtttaatatccactttgaaaaagaaaacaaataagtttatttatgctatacatgatgaaacatcttataaaggaaaaaaaataccgaaagaccaaaaatcagaactaattaactgttcagcccagtttgaagcaaatgcttttgaagcaccacttacatttgcaaatgctgattcaggtttattgcattcttctgtgaaaagaagctgttcacagaatgattctgaagaaccaactttgtccttaactagctcttttgggacaattctgaggaaatgttctagaaatgaaacatgttctaataatacagtaatctctcaggatcttgattataaagaagcaaaatgtaataaggaaaaactacagttatttattaccccagaagctgattctctgtcatgcctgcaggaaggacagtgtgaaaatgatccaaaaagcaaaaaagtttcagatataaaagaagaggtcttggctgcagcatgtcacccagtacaacattcaaaagtggaatacagtgatactgactttcaatcccagaaaagtcttttatatgatcatgaaaatgccagcactcttattttaactcctacttccaaggatgttctgtcaaacctagtcatgatttctagaggcaaagaatcatacaaaatgtcagacaagctcaaaggtaacaattatgaatctgatgttgaattaaccaaaaatattcccatggaaaagaatcaagatgtatgtgctttaaatgaaaattataaaaacgttgagctgttgccacctgaaaaatacatgagagtagcatcaccttcaagaaaggtacaattcaaccaaaacacaaatctaagagtaatccaaaaaaatcaagaagaaactacttcaatttcaaaaataactgtcaatccagactctgaagaacttttctcagacaatgagaataattttgtcttccaagtagctaatgaaaggaataatcttgctttaggaaatactaaggaacttcatgaaacagacttgacttgtgtaaacgaacccattttcaagaactctaccatggttttatatggagacacaggtgataaacaagcaacccaagtgtcaattaaaaaagatttggtttatgttcttgcagaggagaacaaaaatagtgtaaagcagcatataaaaatgactctaggtcaagatttaaaatcggacatctccttgaatatagataaaataccagaaaaaaataatgattacatgaacaaatgggcaggactcttaggtccaatttcaaatcacagttttggaggtagcttcagaacagcttcaaataaggaaatcaagctctctgaacataacattaagaagagcaaaatgttcttcaaagatattgaagaacaatatcctactagtttagcttgtgttgaaattgtaaataccttggcattagataatcaaaagaaactgagcaagcctcagtcaattaatactgtatctgcacatttacagagtagtgtagttgtttctgattgtaaaaatagtcatataacccctcagatgttattttccaagcaggattttaattcaaaccataatttaacacctagccaaaaggcagaaattacagaactttctactatattagaagaatcaggaagtcagtttgaatttactcagtttagaaaaccaagctacatattgcagaagagtacatttgaagtgcctgaaaaccagatgactatcttaaagaccacttctgaggaatgcagagatgctgatcttcatgtcataatgaatgccccatcgattggtcaggtagacagcagcaagcaatttgaaggtacagttgaaattaaacggaagtttgctggcctgttgaaaaatgactgtaacaaaagtgcttctggttatttaacagatgaaaatgaagtggggtttaggggcttttattctgctcatggcacaaaactgaatgtttctactgaagctctgcaaaaagctgtgaaactgtttagtgatattgagaatattagtgaggaaacttctgcagaggtacatccaataagtttatcttcaagtaaatgtcatgattctgttgtttcaatgtttaagatagaaaatcataatgataaaactgtaagtgaaaaaaataataaatgccaactgatattacaaaataatattgaaatgactactggcacttttgttgaagaaattactgaaaattacaagagaaatactgaaaatgaagataacaaatatactgctgccagtagaaattctcataacttagaatttgatggcagtgattcaagtaaaaatgatactgtttgtattcataaagatgaaacggacttgctatttactgatcagcacaacatatgtcttaaattatctggccagtttatgaaggagggaaacactcagattaaagaagatttgtcagatttaacttttttggaagttgcgaaagctcaagaagcatgtcatggtaatacttcaaataaagaacagttaactgctactaaaacggagcaaaatataaaagattttgagacttctgatacattttttcagactgcaagtgggaaaaatattagtgtcgccaaagagtcatttaataaaattgtaaatttctttgatcagaaaccagaagaattgcataacttttccttaaattctgaattacattctgacataagaaagaacaaaatggacattctaagttatgaggaaacagacatagttaaacacaaaatactgaaagaaagtgtcccagttggtactggaaatcaactagtgaccttccagggacaacccgaacgtgatgaaaagatcaaagaacctactctattgggttttcatacagctagcgggaaaaaagttaaaattgcaaaggaatctttggacaaagtgaaaaacctttttgatgaaaaagagcaaggtactagtgaaatcaccagttttagccatcaatgggcaaagaccctaaagtacagagaggcctgtaaagaccttgaattagcatgtgagaccattgagatcacagctgccccaaagtgtaaagaaatgcagaattctctcaataatgataaaaaccttgtttctattgagactgtggtgccacctaagctcttaagtgataatttatgtagacaaactgaaaatctcaaaacatcaaaaagtatctttttgaaagttaaagtacatgaaaatgtagaaaaagaaacagcaaaaagtcctgcaacttgttacacaaatcagtccccttattcagtcattgaaaattcagccttagctttttacacaagttgtagtagaaaaacttctgtgagtcagacttcattacttgaagcaaaaaaatggcttagagaaggaatatttgatggtcaaccagaaagaataaatactgcagattatgtaggaaattatttgtatgaaaataattcaaacagtactatagctgaaaatgacaaaaatcatctctccgaaaaacaagatacttatttaagtaacagtagcatgtctaacagctattcctaccattctgatgaggtatataatgattcaggatatctctcaaaaaataaacttgattctggtattgagccagtattgaagaatgttgaagatcaaaaaaacactagtttttccaaagtaatatccaatgtaaaagatgcaaatgcatacccacaaactgtaaatgaagatatttgcgttgaggaacttgtgactagctcttcaccctgcaaaaataaaaatgcagccattaaattgtccatatctaatagtaataattttgaggtagggccacctgcatttaggatagccagtggtaaaatcgtttgtgtttcacatgaaacaattaaaaaagtgaaagacatatttacagacagtttcagtaaagtaattaaggaaaacaacgagaataaatcaaaaatttgccaaacgaaaattatggcaggttgttacgaggcattggatgattcagaggatattcttcataactctctagataatgatgaatgtagcacgcattcacataaggtttttgctgacattcagagtgaagaaattttacaacataaccaaaatatgtctggattggagaaagtttctaaaatatcaccttgtgatgttagtttggaaacttcagatatatgtaaatgtagtatagggaagcttcataagtcagtctcatctgcaaatacttgtgggatttttagcacagcaagtggaaaatctgtccaggtatcagatgcttcattacaaaacgcaagacaagtgttttctgaaatagaagatagtaccaagcaagtcttttccaaagtattgtttaaaagtaacgaacattcagaccagctcacaagagaagaaaatactgctatacgtactccagaacatttaatatcccaaaaaggcttttcatataatgtggtaaattcatctgctttctctggatttagtacagcaagtggaaagcaagtttccattttagaaagttccttacacaaagttaagggagtgttagaggaatttgatttaatcagaactgagcatagtcttcactattcacctacgtctagacaaaatgtatcaaaaatacttcctcgtgttgataagagaaacccagagcactgtgtaaactcagaaatggaaaaaacctgcagtaaagaatttaaattatcaaataacttaaatgttgaaggtggttcttcagaaaataatcactctattaaagtttctccatatctctctcaatttcaacaagacaaacaacagttggtattaggaaccaaagtgtcacttgttgagaacattcatgttttgggaaaagaacaggcttcacctaaaaacgtaaaaatggaaattggtaaaactgaaactttttctgatgttcctgtgaaaacaaatatagaagtttgttctacttactccaaagattcagaaaactactttgaaacagaagcagtagaaattgctaaagcttttatggaagatgatgaactgacagattctaaactgccaagtcatgccacacattctctttttacatgtcccgaaaatgaggaaatggttttgtcaaattcaagaattggaaaaagaagaggagagccccttatcttagtgggagaaccctcaatcaaaagaaacttattaaatgaatttgacaggataatagaaaatcaagaaaaatccttaaaggcttcaaaaagcactccagatggcacaataaaagatcgaagattgtttatgcatcatgtttctttagagccgattacctgtgtaccctttcgcacaactaaggaacgtcaagagatacagaatccaaattttaccgcacctggtcaagaatttctgtctaaatctcatttgtatgaacatctgactttggaaaaatcttcaagcaatttagcagtttcaggacatccattttatcaagtttctgctacaagaaatgaaaaaatgagacacttgattactacaggcagaccaaccaaagtctttgttccaccttttaaaactaaatcacattttcacagagttgaacagtgtgttaggaatattaacttggaggaaaacagacaaaagcaaaacattgatggacatggctctgatgatagtaaaaataagattaatgacaatgagattcatcagtttaacaaaaacaactccaatcaagcagcagctgtaactttcacaaagtgtgaagaagaacctttagatttaattacaagtcttcagaatgccagagatatacaggatatgcgaattaagaagaaacaaaggcaacgcgtctttccacagccaggcagtctgtatcttgcaaaaacatccactctgcctcgaatctctctgaaagcagcagtaggaggccaagttccctctgcgtgttctcataaacagctgtatacgtatggcgtttctaaacattgcataaaaattaacagcaaaaatgcagagtcttttcagtttcacactgaagattattttggtaaggaaagtttatggactggaaaaggaatacagttggctgatggtggatggctcataccctccaatgatggaaaggctggaaaagaagaattttatagggctctgtgtgacactccaggtgtggatccaaagcttatttctagaatttgggtttataatcactatagatggatcatatggaaactggcagctatggaatgtgcctttcctaaggaatttgctaatagatgcctaagcccagaaagggtgcttcttcaactaaaatacagatatgatacggaaattgatagaagcagaagatcggctataaaaaagataatggaaagggatgacacagctgcaaaaacacttgttctctgtgtttctgacataatttcattgagcgcaaatatatctgaaacttctagcaataaaactagtagtgcagatacccaaaaagtggccattattgaacttacagatgggtggtatgctgttaaggcccagttagatcctcccctcttagctgtcttaaagaatggcagactgacagttggtcagaagattattcttcatggagcagaactggtgggctctcctgatgcctgtacacctcttgaagccccagaatctcttatgttaaagatttctgctaacagtactcggcctgctcgctggtataccaaacttggattctttcctgaccctagaccttttcctctgcccttatcatcgcttttcagtgatggaggaaatgttggttgtgttgatgtaattattcaaagagcataccctatacagtggatggagaagacatcatctggattatacatatttcgcaatgaaagagaggaagaaaaggaagcagcaaaatatgtggaggcccaacaaaagagactagaagccttattcactaaaattcaggaggaatttgaagaacatgaagaaaacacaacaaaaccatatttaccatcacgtgcactaacaagacagcaagttcgtgctttgcaagatggtgcagagctttatgaagcagtgaagaatgcagcagacccagcttaccttgagggttatttcagtgaagagcagttaagagccttgaataatcacaggcaaatgttgaatgataagaaacaagctcagatccagttggaaattaggaaggccatggaatctgctgaacaaaaggaacaaggtttatcaagggatgtcacaaccgtgtggaagttgcgtattgtaagctattcaaaaaaagaaaaagattcagttatactgagtatttggcgtccatcatcagatttatattctctgttaacagaaggaaagagatacagaatttatcatcttgcaacttcaaaatctaaaagtaaatctgaaagagctaacatacagttagcagcgacaaaaaaaactcagtatcaacaactaccggtttcagatgaaattttatttcagatttaccagccacgggagccccttcacttcagcaaatttttagatccagactttcagccatcttgttctgaggtggacctaataggatttgtcgtttctgttgtgaaaaaaacaggacttgcccctttcgtctatttgtcagacgaatgttacaatttactggcaataaagttttggatagaccttaatgaggacattattaagcctcatatgttaattgctgcaagcaacctccagtggcgaccagaatccaaatcaggccttcttactttatttgctggagatttttctgtgttttctgctagtccaaaagagggccactttcaagagacattcaacaaaatgaaaaatactgttgagaatattgacatactttgcaatgaagcagaaaacaagcttatgcatatactgcatgcaaatgatcccaagtggtccaccccaactaaagactgtacttcagggccgtacactgctcaaatcattcctggtacaggaaacaagcttctgatgtcttctcctaattgtgagatatattatcaaagtcctttatcactttgtatggccaaaaggaagtctgtttccacacctgtctcagcccagatgacttcaaagtcttgtaaaggggagaaagagattgatgaccaaaagaactgcaaaaagagaagagccttggatttcttgagtagactgcctttacctccacctgttagtcccatttgtacatttgtttctccggctgcacagaaggcatttcagccaccaaggagttgtggcaccaaatacgaaacacccataaagaaaaaagaactgaattctcctcagatgactccatttaaaaaattcaatgaaatttctcttttggaaagtaattcaatagctgacgaagaacttgcattgataaatacccaagctcttttgtctggttcaacaggagaaaaacaatttatatctgtcagtgaatccactaggactgctcccaccagttcagaagattatctcagactgaaacgacgttgtactacatctctgatcaaagaacaggagagttcccaggccagtacggaagaatgtgagaaaaataagcaggacacaattacaactaaaaaatatatctagggcctcatgggcccagctttcttgtacaaagtggt").toUpperCase()));
        //for (String gene : genes.data()) {
        //    System.out.println(gene);
            // genes.add(gene);
        //}

        // test.add(dna);
        // processGenes(test);
    }
}
