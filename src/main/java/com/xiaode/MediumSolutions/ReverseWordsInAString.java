package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length-1; i >= 0; i--) {
            String word = words[i].trim();
            if (word.length() > 0) {
                sb.append(word);
                if (i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}
