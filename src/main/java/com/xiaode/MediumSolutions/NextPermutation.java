package com.xiaode.MediumSolutions;


import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by liyangde on Nov, 2018
 *
 * 31. Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while (index > 0 && nums[index] <= nums[index - 1]) {
            --index;
        }

        if (index == 0) {
            Arrays.sort(nums);
            return;
        }

        int second = Integer.MAX_VALUE, secondIndex = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= index - 1; --i) {
            if (nums[i] > nums[index - 1] && nums[i] < second) {
                second = nums[i];
                secondIndex = i;
            }
        }

        int tmp = nums[index - 1];
        nums[index - 1] = nums[secondIndex];
        nums[secondIndex] = tmp;
        Arrays.sort(nums, index, nums.length);
    }
}
