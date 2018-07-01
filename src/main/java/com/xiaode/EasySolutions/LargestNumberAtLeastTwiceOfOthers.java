package com.xiaode.EasySolutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 748. Largest Number At Least Twice of Others
 * In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, otherwise return -1.
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        if(nums.length  == 0) return -1;
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if ( nums[i] > max ) {
                max = nums[i];
                index = i;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (j == index) continue;
            if ( nums[j] * 2 > max ) return -1;
        }
        return index;
    }

}
