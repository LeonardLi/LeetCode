package com.xiaode.MediumSolutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyangde on Jun, 2019
 *
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.
 *
 *
 *
 * Example 1:
 *
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 *
 * Input: "AAABBC"
 * Output: 188
 *
 *
 * Note:
 *
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String t) {
        int [] count = new int[26];
        for(char c : t.toCharArray()) count[c-'A']++;
        return helper(count);
    }

    private int helper(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            sum++;
            arr[i]--;
            sum += helper(arr);
            arr[i]++;
        }
        return sum;
    }
}
