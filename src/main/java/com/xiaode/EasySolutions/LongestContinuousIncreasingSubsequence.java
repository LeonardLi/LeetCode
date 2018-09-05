package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 674. Longest Continuous Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return 1;
        int count = 1;
        int maxLength = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) count++;
            if (nums[i] >= nums[i + 1]) {
                maxLength = count > maxLength? count : maxLength;
                count = 1;
            }

        }
        return count > maxLength  ? count : maxLength;
    }

}
