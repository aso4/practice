import java.util.Arrays;
import edu.duke.FileResource;
/**
 * Write a description of CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        char newChar;
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            boolean isLowerCase = Character.isLowerCase(currChar);

            if (idx != -1) {
                if (isLowerCase) {
                    newChar = Character.toLowerCase(shiftedAlphabet.charAt(idx));
                } else {
                    newChar = shiftedAlphabet.charAt(idx);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    public void testCaesar() {
        //int key = 17;

        // FileResource fr = new FileResource();
        // String message = fr.asString();
        // String encrypted = encrypt(message, key);
        // System.out.println("key is " + key + "\n" + encrypted);
        // String decrypted = encrypt(encrypted, 26-key);
        // System.out.println(decrypted);

        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(encrypt("First Legion", 23));
        System.out.println(encrypt("First Legion", 17));

    }

    private String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        // System.out.println(shiftedAlphabet1 + " " + shiftedAlphabet2);
        // System.out.println("01234567890123456789012345 01234567890123456789012345");

        for (int i = 0; i < encrypted.length(); i++) {
            char newChar;
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            boolean isLowerCase = Character.isLowerCase(currChar);

            if (idx != -1) {
                if (i % 2 != 0) {
                    newChar = shiftedAlphabet2.charAt(idx);
                    // System.out.println("odd");
                } else {
                    newChar = shiftedAlphabet1.charAt(idx);
                }

                if (isLowerCase) {
                    newChar = Character.toLowerCase(newChar);
                    // System.out.println("currChar: " + currChar + " idx: " + idx + " newChar: " + newChar);
                }
                encrypted.setCharAt(i, newChar);
            }

        }
        return encrypted.toString();
    }

    public void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
        // Czojq Ivdzle
        // actual: Czojq Ivxzfk
    }
}
