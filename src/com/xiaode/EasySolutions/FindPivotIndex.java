package com.xiaode.EasySolutions;


/**
 * 724. Find Pivod Index
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivod index as the index where the sum of the numbers to the left of the index is equal to the numbers
 * to the right of the index.
 * if no such index exists, we should return -1. if there are multiple pivod indexes, you should return the left-most pivot
 * index.
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        FindPivotIndex f = new FindPivotIndex();
        f.pivotIndex(new int[]{1,7,3,6,5,6});
    }
    public int pivotIndex(int[] nums) {
        //naive way, violent count and search
        //corner case
        if (nums.length < 3) return -1;

        int leftSum = 0;
        int rightSum = 0;
        for(int p = 0; p < nums.length - 1; p++){
            //right sum
            for (int j = p+1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            // left sum
            for (int j = 0; j < p; j++) {
                leftSum += nums[j];
            }

            if (leftSum == rightSum) return p;
            leftSum = 0;
            rightSum = 0;
        }

        return -1;

    }

    public int pivotIndex2(int[] nums) {
        // Better way
        // avoid to calculate twice
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left += nums[i - 1];
            if (sum - left - nums[i] == left) return i;
        }

        return -1;
    }
}
