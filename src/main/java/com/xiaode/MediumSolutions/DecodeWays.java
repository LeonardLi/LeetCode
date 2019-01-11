package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Dec, 2018
 *
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.startsWith("0")) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++ ) {
            if(s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')
                    dp[i] = dp[i-1];
            } else {
                if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i)-'0' <= 6)) {
                    if (i >=2) {
                        dp[i] = dp[i-1] + dp[i-2];
                    }else {
                        dp[i] = dp[i-1] + 1;
                    }
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }

        if (s.charAt(s.length() - 1) == '0' && dp[s.length()-1] > 1) dp[s.length()-1] = dp[s.length()-3];

        return dp[s.length() - 1];
    }
}
