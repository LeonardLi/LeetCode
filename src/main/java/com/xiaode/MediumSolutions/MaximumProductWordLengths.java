package com.xiaode.MediumSolutions;

import java.util.HashSet;

/**
 * Created by liyangde on Jul, 2018
 *
 * 318. Maximum Product of Word Lengths
 *
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not
 * share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 */
public class MaximumProductWordLengths {

    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (checkWords(words[i], words[j])) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }

    private boolean checkWords(String word1, String word2){
        HashSet<Character> word = new HashSet<>();
        for (Character c : word1.toCharArray()) {
            word.add(c);
        }

        for (Character c : word2.toCharArray()) {
            if (word.contains(c)) return false;
        }
        return true;

    }

    ///// fast way
    ///// use 1 int space （32 bit）store the the letter in a word, use bit operation to accelarate
    public int maxProduct2(String[] words) {
        int n = words.length, max = 0;
        int[] values = new int[n];

        for(int i = 0; i < n; i++) {
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                values[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if((values[i] & values[j]) == 0 && (words[i].length() * words[j].length() > max)) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}
