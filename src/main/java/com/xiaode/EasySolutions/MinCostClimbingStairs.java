package com.xiaode.EasySolutions;

/**
 * 747. Min Cost Climbing Stairs
 *  On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed)
 *  Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the
 *  floor, an you can either start from the step with index 0, or the step with index 1.
 */
public class MinCostClimbingStairs {
//DP
    public int minCostClimbingStairs(int[] costs) {
        int[] mc = new int[costs.length + 1];
        mc[0] = costs[0];
        mc[1] = costs[1];

        for (int i = 2; i <= costs.length; i++) {
            int costV = (i == costs.length) ? 0 : costs[i];
            mc[i] = Math.min(mc[i-1] + costV, mc[i-2] + costV);
         }
         return mc[costs.length];
    }
}
