package com.xiaode.EasySolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Aug, 2018
 *
 * 268. Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
               return i;
            }
        }

        return nums.length;
    }

    // sum
    public int missingNumber1(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    //Bit Manipulation XOR very cool
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
