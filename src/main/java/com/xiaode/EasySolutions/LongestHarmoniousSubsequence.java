package com.xiaode.EasySolutions;

import java.util.HashMap;

/**
 * Created by liyangde on Sep, 2018
 *
 * 594. Longest Harmonious Subsequence
 *
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap< >();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;

    }
}
