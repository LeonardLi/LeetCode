package com.xiaode.EasySolutions;

import java.util.HashSet;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        for (int i: nums) {
            result.add(i);
        }
        Integer[] numbers =  result.toArray(new Integer[0]);
        for (int i = 0; i < numbers.length ; i++) {
            nums[i] = numbers[i];
        }
        int length = nums.length;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            if (cur == 0) continue;
            for (int j = i+1; j < nums.length; j++) {
                if ( nums[j] == cur) {
                    nums[j] = 0;
                    length--;
                }
            }

        }
        return length;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        r.removeDuplicates(new int[]{1,1,2});
    }
}
