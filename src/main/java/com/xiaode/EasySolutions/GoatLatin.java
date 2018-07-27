package com.xiaode.EasySolutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by liyangde on Jul, 2018
 *
 * 824. Goat Latin
 *
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 *
 */
public class GoatLatin {

    public String toGoatLatin(String S) {
        if (S == null) return S;
        List<Character> dict =Arrays.asList('a','e','i','o','u','A','E','I','O','U');

        String[] words = S.split(" ");
        String suffix = "";
        for (int i = 0; i < words.length; i++) {
            suffix+="a";
            if (dict.contains(words[i].charAt(0))) {
                words[i] = words[i] + "ma";
            }
            else {
                words[i] = words[i].substring(1) + words[i].charAt(0) + "ma";
            }

            words[i] += suffix;

        }
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            sb.append(" " + words[i]);
        }
        S = sb.toString();
        return S;
    }
}
