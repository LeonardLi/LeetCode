package com.xiaode.EasySolutions;



import java.util.ArrayList;

/**
 * Created by liyangde on Aug, 2018
 *
 * 345. Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsOfString {

    public String reverseVowels(String s) {
        String vowels = "AEIOUaeiou";
        char[] word = s.toCharArray();
        ArrayList<Character> indexs = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            if (vowels.indexOf(word[i]) != -1) indexs.add(word[i]);
        }

        for (int j = 0, i = indexs.size() - 1; j < word.length; j++) {
            if (vowels.indexOf(word[j]) != -1) word[j] = indexs.get(i--);
        }

        return new String(word);
    }
}
