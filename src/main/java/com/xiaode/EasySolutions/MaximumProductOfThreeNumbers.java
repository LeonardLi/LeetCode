package com.xiaode.EasySolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Sep, 2018
 *
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1] * nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers maximumProductOfThreeNumbers = new MaximumProductOfThreeNumbers();
        int[] nums = {1,2,3,4};
        maximumProductOfThreeNumbers.maximumProduct(nums);
    }
}
