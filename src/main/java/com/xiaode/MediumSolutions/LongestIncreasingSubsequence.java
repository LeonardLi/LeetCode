package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 300. Longest Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, nums, new ArrayList<>(), 0);
        int res = 0;
        for (List<Integer> list1 : list) {
            res = Math.max(res, list1.size());
        }
        return res;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, List<Integer> temp, int start){
        list.add(new ArrayList<>(temp));
        if (list.size() != 0) {
            if (temp.size() > list.get(0).size()) {
                list.remove(0);
                list.add(new ArrayList<>(temp));
            }
        } else {
            list.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            if (temp.size() > 0 && nums[i] <= temp.get(temp.size() - 1)) {
                continue;
            }
            else temp.add(nums[i]);

            backtrack(list, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    //DP better
    public int lengthOfLIS2(int[] nums){
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 0;
        int max = 1;

        for (int i = 1; i < dp.length; i++) {
            int maxval = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval,dp[j]);
                }
            }
            dp[i] = maxval + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        longestIncreasingSubsequence.lengthOfLIS2(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
