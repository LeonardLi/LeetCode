package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 2/21/17.
 */
public class NextGreaterElementI {
    /**
     * 496. Next Greater Element I
     * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
     * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
     * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums){
        int [] result = new int[findNums.length];
        for(int i = 0; i < findNums.length; i++){
            result[i] = -1;
            for(int j = i; j < nums.length; j++){
                if (findNums[i] < nums[j]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }
        return result;

    }
}
