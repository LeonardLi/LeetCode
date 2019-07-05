package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 *
 * 1055. Shortest Way to Form String
 *
 * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
 *
 * Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.
 *
 *
 */
public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        // check if target constains letters not int source
        int[] dic = new int[26];
        for (char c : source.toCharArray()) dic[c-'a']++;
        for (char c : target.toCharArray()) {
            if (dic[c] == 0) return -1;
        }
        // two pointers
        int start = 0, end = 0, res = 0;
        while(start <= target.length() && end <= target.length()){
            String s = target.substring(start, end);
            if (isSubsequnce(s, source)) end++;
            else {
                res++;
                start = end-1;
            }
        }
        return start == end ? res : res+1;
    }

    boolean isSubsequnce(String s, String t) {
        int pos = 0;
        for (int i = 0; i < t.length() && pos < s.length(); i++) {
            if(s.charAt(pos) == t.charAt(i)) pos++;
        }
        if (pos == s.length()) return true;
        return false;
    }
}
