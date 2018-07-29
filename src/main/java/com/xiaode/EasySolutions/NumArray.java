package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 303. Range Sum Query - Immutable
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 */
public class NumArray {
    final int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == j) return nums[i];
        int res = 0;
        for (int start = i; start <= j; start++) {
            res += nums[start];
        }
        return res;
    }

    //lazy loading

    private int[] sums;
    public void NumArray2(int[] nums) {
        if(nums.length != 0){
            sums = new int[nums.length];

            sums[0] = nums[0];
            for(int i=1; i<nums.length; i++){
                sums[i] = nums[i] + sums[i-1];
            }
        }
    }

    public int sumRange2(int i, int j) {
        return i==0 ? sums[j] : sums[j]-sums[i-1];
    }
}
