package com.xiaode.HardSolutions;

/**
 * Created by liyangde on Dec, 2018
 *
 * 727. Minimum Window Subsequence
 *
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 *
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
 *
 * Example 1:
 *
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 *
 *
 * Note:
 *
 * All the strings in the input will only contain lowercase letters.
 * The length of S will be in the range [1, 20000].
 * The length of T will be in the range [1, 100].
 *
 */
public class MinimumWindowSubsequence {

    public String minWindow(String S, String T) {
        int[][] M = new int[S.length()][T.length()];
        for(int i = 0; i < S.length(); i ++){
            if(S.charAt(i) == T.charAt(0)){
                M[i][0] = i;        //  largest starting index matches only first char in T
            }else{
                if(i == 0){
                    M[i][0] = -1;    // S, T both have 1 char, if !match, fill -1 means we can't find a substring for S(0) & T(0)
                }else{
                    M[i][0] = M[i - 1][0];
                }
            }
        }
        for(int j = 1; j < T.length(); j ++){
            for(int i = 0; i < S.length(); i ++){
                if(S.charAt(i) == T.charAt(j)){
                    if(i == 0){
                        M[i][j] = -1;       //  Actually, if j > i, M[i][j] is always -1, cause we cant find a substring of a shorter string matches a longer string
                    }else{
                        M[i][j] = M[i - 1][j - 1];  // As share2017 mentioned in his post
                    }
                }else{
                    if(i == 0){
                        M[i][j] = -1;
                    }else{
                        M[i][j] = M[i - 1][j];
                    }
                }
            }
        }
        int start = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < S.length(); i ++){
            if(M[i][T.length() - 1] != -1){
                if(i - M[i][T.length() - 1] + 1 < len){
                    len = i - M[i][T.length() - 1] + 1;
                    start = M[i][T.length() - 1];
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);
    }
}
