package com.xiaode.EasySolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Jul, 2018
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 *
 * then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        if(nums==null || nums.length<=1) return 0;

        int[] originalArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);

        int start = 0, end= 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != originalArray[i]) {
                start = i;
                break;
            }
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != originalArray[j]) {
                end = j;
                break;
            }
        }
        if (end == start) return 0;
        return end - start + 1;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = new ShortestUnsortedContinuousSubarray();

        int[] test = {2,6,4,8,10,9,15};

        shortestUnsortedContinuousSubarray.findUnsortedSubarray(test);

    }
}
