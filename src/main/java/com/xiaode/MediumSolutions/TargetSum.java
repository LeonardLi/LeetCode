package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 494. Target Sum
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {

    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, 0, 0, S);
        return count;
    }

    private void backtrack(int[] nums, int index, int temp, int S){
        if (index == nums.length) {
            if (temp == S) count++;
            return;
        }

        backtrack(nums, index + 1, temp + nums[index], S);

        backtrack(nums, index + 1, temp - nums[index], S);

    }


    public int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays2(new int[]{1,1,1,1,1}, 3));

    }
}
