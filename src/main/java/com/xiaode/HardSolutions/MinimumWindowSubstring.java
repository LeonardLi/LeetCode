package com.xiaode.HardSolutions;

/**
 * Created by liyangde on Dec, 2018
 *
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

    public String minwindow(String s, String t) {
        int[] map = new int[128];
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int begin = 0;
        int counter = t.length();

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'A']++;
        }

        while (right < s.length()) {
            if (map[s.charAt(right++) - 'A']-- > 0) counter--;
            while (counter == 0) {
                if (right - left < res) {
                    res = right - left;
                    begin = left;
                }

                if (map[s.charAt(left++) - 'A']++ == 0) counter++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(begin, begin+res);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        m.minwindow("ADOBECODEBANC", "ABC");
    }
}
