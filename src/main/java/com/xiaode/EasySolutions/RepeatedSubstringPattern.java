package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 459. Repeated Substring Pattern
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of
 *
 * the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 *
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 *
 *
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1 ) return  false;
        //corner case
        boolean isSub = false;
        char subChar = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != subChar) {
                isSub = false;
                break;

            }else {
                isSub = true;
            }
        }
        if (isSub) return true;


        //trivial case
        int length = 2;
        //char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (length > s.length() / 2) break;
            if (s.length() % length != 0) {
                length ++;
                continue;
            }

            String substring = s.substring(0, length);
            for (int j = length; j <= s.length() - length; j += length) {
                if (! substring.equals(s.substring(j, j + length))){
                    continue;
                } else {
                    if (j + length == s.length()) return true;
                }
            }

            length++;
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        String test = "abab";

        repeatedSubstringPattern.repeatedSubstringPattern(test);
    }
}
