package com.xiaode.EasySolutions;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by liyangde on Nov, 2018
 *
 * 940. Distinct Subsequences II
 * User Accepted: 363
 * User Tried: 746
 * Total Accepted: 381
 * Total Submissions: 1679
 * Difficulty: Hard
 * Given a string S, count the number of distinct, non-empty subsequences of S .
 *
 * Since the result may be large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 * Example 2:
 *
 * Input: "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
 * Example 3:
 *
 * Input: "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 */
public class DistinctSubsequencesII {

    //TLE
    public int distinctSubseqII(String S) {
        HashSet<String> set = new HashSet<>();
        backtrack(S, "", set, 0);
        return set.size()-1;
    }
    private void backtrack(String S, String temp,HashSet<String> set, int index){
        if (!set.contains(temp)) set.add(temp);

        for(int i = index; i < S.length(); i++) {
            backtrack(S,temp+S.charAt(i), set, i+1);
        }
    }

    public int distinctSubseqII2(String S) {
        int n = S.length(), M = (int)1e9+7, result = 0;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i=0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (S.charAt(j) != S.charAt(i)) {
                    dp[i] += dp[j];
                    dp[i] %= M;
                }
            }
            result += dp[i];
            result %= M;
        }

        return result;
    }

    public static void main(String[] args) {
        DistinctSubsequencesII subsequencesII = new DistinctSubsequencesII();
        subsequencesII.distinctSubseqII("aba");
    }
}
