package com.xiaode.MediumSolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyangde on Nov, 2018
 *
 * 325. Maximum Size Subarray Equals k
 *
 */
public class MaximumSizeSubarraySumEqualsk {

    public int maxSubArrayLen(int[] nums, int k){
        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, i - index.getOrDefault(sum - k, i));
            index.putIfAbsent(sum, i);
        }
        return max;
    }
}
