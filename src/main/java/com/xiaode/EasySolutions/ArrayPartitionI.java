package com.xiaode.EasySolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Aug, 2018
 *
 * 561. Array Partition I
 *
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ...,
 *
 * (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
