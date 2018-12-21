package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Dec, 2018
 *
 * 161. One Edit Distance
 *
 * Given two strings s and t, determine if they are both one edit distance apart.
 *
 * Note:
 *
 * There are 3 possiblities to satisify one edit distance apart:
 *
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 *
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 *
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 *
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */
public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            //replace
            return canReplace(s, t);
        } else if (s.length() < t.length()) {
            //insert
            return canInsert(s, t);
        } else {
            //delete
            return canInsert(t, s);
        }
    }

    private boolean canInsert(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return t.substring(i+1).equals(s.substring(i));
            }
        }
        return t.length() - s.length() == 1;
    }

    private boolean canReplace(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return t.substring(i+1).equals(s.substring(i+1));
            }
        }
        return false;
    }

}
