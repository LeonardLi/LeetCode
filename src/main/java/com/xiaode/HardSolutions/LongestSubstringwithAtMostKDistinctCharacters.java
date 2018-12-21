package com.xiaode.HardSolutions;

import java.util.HashSet;

/**
 * Created by liyangde on Dec, 2018
 *
 * 340. Longest Substring with At Most K Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int [][] dp  = new int[s.length()][s.length()];
        int max = 0;
        for(int start = 0; start < s.length(); start++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(start));
            dp[start][start] = 1;
            for(int end = start+1; end < s.length(); end++) {
                if (set.contains(s.charAt(end))){
                    dp[start][end] = dp[start][end-1];
                }else {
                    dp[start][end] = dp[start][end-1]+1;
                    set.add(s.charAt(end));
                }

                if(set.size() == k) {
                    max = Math.max(max, end-start);
                }
            }
        }

        return max;
    }

    // slide window, much better
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args){
        LongestSubstringwithAtMostKDistinctCharacters l = new LongestSubstringwithAtMostKDistinctCharacters();
        l.lengthOfLongestSubstringKDistinct("eceba", 2);
    }
}
