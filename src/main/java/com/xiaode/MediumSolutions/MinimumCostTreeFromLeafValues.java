package com.xiaode.MediumSolutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by liyangde on Jul, 2019
 *
 * 1130. Minimum Cost Tree From Leaf Values
 */
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solver(A, 0, n-1, dp);

    }
    int solver(int[] A, int low, int high, int[][]dp) {
        if (low == high) return 0;
        if (dp[low][high] != -1) return dp[low][high];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = low; i <= high; i++) pq.add(A[i]);
        int a = pq.poll();
        int b = pq.poll();
        int maxProduct = a*b;
        int minSum = Integer.MAX_VALUE;
        for (int i = low; i < high; i++) {
            minSum = Math.min(minSum, solver(A, low, i, dp) + solver(A, i+1, high, dp));
        }
        dp[low][high] = minSum + maxProduct;
        return dp[low][high];
    }
}
