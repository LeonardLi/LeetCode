package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 2/21/17.
 */
public class MinimumMoves {
    /**
     * 453. Minimum Moves to Equal Array Elements
     * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements
     * equal, where a move is incrementing n - 1 elements by 1.
     */
    public int minMoves(int[] nums){
        if (nums.length == 0 ) return 0;
        int min = nums[0];
        for (int n: nums){
            min = Math.min(min,n);
        }
        int res = 0;
        for (int n:nums
                ) {
            res += n-min;

        }
        return res;
    }
}
