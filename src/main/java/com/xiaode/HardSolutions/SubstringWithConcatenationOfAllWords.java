package com.xiaode.HardSolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liyangde on Apr, 2019
 *
 * Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
