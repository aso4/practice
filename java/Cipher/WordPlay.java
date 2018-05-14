import java.util.Arrays;
/**
 * Write a description of WordPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay {
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels) {
            if (ch == vowel) {
                return true;
            }
        }
        return false;
    }

    public void testIsVowel() {
        char ch = 'b';
        System.out.println("isVowel: " + isVowel(ch));
        char ch2 = 'a';
        System.out.println("isVowel: " + isVowel(ch2));
    }

    private String replaceVowels(String phrase, char ch) {
        String s = "";

        for (char c : phrase.toCharArray()) {
            if (isVowel(c)) {
                s += ch;
            } else {
                s += c;
            }
        }

        return s;
    }

    public void testReplaceVowels() {
        System.out.println("replaceVowels : " + replaceVowels("phrase", 'x'));
    }

    private String emphasize(String phrase, char ch) {
        String s = "";
        char[] phraseArray = phrase.toCharArray();
        for (int i = 0; i < phrase.length(); i++) {
            if (phraseArray[i] == ch) {
                if (i % 2 == 0) {
                    s += '*';
                } else {
                    s += '+';
                }
            } else {
                s += phraseArray[i];
            }
        }
        return s;
    }

    public void testEmphasize() {
        System.out.println("emphasize: " + emphasize("dna ctgaaactga", 'a'));
        System.out.println("emphasize: " + emphasize("Mary Bella Abracadabra", 'a'));
    }
}
