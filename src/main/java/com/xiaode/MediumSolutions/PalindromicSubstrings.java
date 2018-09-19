package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 647. Palindromic Substrings
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note:
 * The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        if(s == null || s.length() == 0) return 0;

        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0, j = i; i < s.length(); i++,j++) dp[i][j] = true;

        for (int i = 0, j = i+1; i < s.length() - 1; i++,j++) {
            if (s.charAt(i) == s.charAt(j)) dp[i][j] = true;
        }
        // pay attention to this i, if is ascending order other than descending order, the result might be wrong
        for (int i = s.length() - 2 ; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) dp[i][j] = true;
            }
        }

        int res = 0;
        for (boolean[] p : dp) {
            for (boolean q : p) {
                if (q) res ++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        palindromicSubstrings.countSubstrings("aaaaa");
    }
}




