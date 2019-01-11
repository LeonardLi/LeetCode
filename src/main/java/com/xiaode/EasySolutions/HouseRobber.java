package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 198. House Robber
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 *
 */

//Todo: fully understand DP algorithm

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < nums.length; i++) {
            if((nums[i] + result[i-2]) > result[i-1])
                result[i] = nums[i] + result[i-2];
            else
                result[i] = result[i-1];
        }
        return result[nums.length - 1];
    }
}
