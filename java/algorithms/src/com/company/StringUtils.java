package com.company;

/**
 * Created by albertso on 4/22/17.
 */
// save work for tomorrow
public class StringUtils {

    public static String toAlternativeString(String string) {
        StringBuilder sb = new StringBuilder(string);
        for (int index = 0; index < string.length(); index++) {
            char c = string.charAt(index);
            Character.isLowerCase(c) ? sb.setCharAt(index, Character.toUpperCase(c)) : sb.setCharAt(index, Character.toLowerCase(c));
//       if (Character.isLowerCase(c)) {
//           sb.setCharAt(index, Character.toUpperCase(c));
//       } else {
//           sb.setCharAt(index, Character.toLowerCase(c));
//       }
        }
        return sb.toString();
    }
}