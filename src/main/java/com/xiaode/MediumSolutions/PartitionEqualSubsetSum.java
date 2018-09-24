package com.xiaode.MediumSolutions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 416. Partition Equal Subset Sum
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */
public class PartitionEqualSubsetSum {

    // recursion TLE
    boolean exisited = false;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum+=i;
        if (sum % 2 != 0) return false;

        backtrack(nums, 0, 0, sum/2);
        return exisited;
    }

    private void backtrack(int[] nums, int tempSum, int start, int sum) {
        if (tempSum == sum) {
            exisited = true;
            return;
        }
        if (tempSum > sum) return;

        for (int i = start; i < nums.length && !exisited; i++) {
            backtrack(nums, tempSum+nums[i], i + 1, sum);
        }
    }


    //DP
    //TODO: Transition function
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums) sum+=i;
        if (sum % 2 != 0) return false;
        sum /=2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];


    }
    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        partitionEqualSubsetSum.canPartition(new int[]{1,5,11,5});
    }
}
