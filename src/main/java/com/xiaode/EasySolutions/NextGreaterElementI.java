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
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int [] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = -1;

            boolean isTarget = false;
            for(int j = 0; j < nums2.length; j++){
                if (isTarget || nums1[i] == nums2[j]){
                    isTarget = true;
                } else {
                    continue;
                }
                if (nums1[i] < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;

    }
}
