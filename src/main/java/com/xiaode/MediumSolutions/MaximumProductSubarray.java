package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int r = nums[0];
        for (int i = 1, imax = r, imin = r; i <= nums.length - 1; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                temp = imin;
                imin = imax;
                imax = temp;
            }
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            r = Math.max(r, imax);
        }

        return r;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] test = {-4, -3};
        maximumProductSubarray.maxProduct(test);
    }
}
