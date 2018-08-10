package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 *
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        if (str == null) return null;
        int length = str.length();
        if (length == 0) return str;

        StringBuilder sb = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if ( c >= 'A' && c <= 'Z'  ) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
