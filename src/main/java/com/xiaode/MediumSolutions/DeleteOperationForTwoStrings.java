package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 *
 * 583. Delete Operation for Two Strings
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int max = LCS(word1.toCharArray(), word2.toCharArray(), word1.length(), word2.length() );
        System.out.println(max);
        return word1.length()+ word2.length() - 2 * max;
    }
// recursion
//    private int LCS(char[] word1, char[] word2, int m, int n) {
//        if(m == 0 || n == 0) return 0;
//        if(word1[m] == word2[n])
//            return LCS(word1, word2, m-1, n-1)+1;
//        else
//            return Math.max(LCS(word1, word2, m-1, n),
//                    LCS(word1, word2, m, n-1));
//    }

    private int LCS(char[] word1, char[] word2, int m, int n) {
        int L[][] = new int[m+1][n+1];
        for (int i = 0; i <= m ; i++) {
            for (int j = 0; j<= n; j++) {
                if (i == 0 || j == 0) L[i][j] = 0;
                else if (word1[i-1] == word2[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings d = new DeleteOperationForTwoStrings();
        d.minDistance("dinitrophenylhydrazine", "benzalphenylhydrazone");

    }
}
