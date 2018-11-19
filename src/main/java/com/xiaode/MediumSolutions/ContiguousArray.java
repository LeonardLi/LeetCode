package com.xiaode.MediumSolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyangde on Nov, 2018
 *
 * 525. Contiguous Array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> mapToIndex = new HashMap<>();
        mapToIndex.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (mapToIndex.containsKey(sum)){
                max = Math.max(max, i - mapToIndex.get(sum));
            } else {
                mapToIndex.put(sum, i);
            }
        }

        return max;
    }

}
