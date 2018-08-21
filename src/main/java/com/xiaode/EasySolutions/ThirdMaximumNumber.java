package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by liyangde on Aug, 2018
 *
 * 414. Third Maximum Number
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the
 *
 * maximum number. The time complexity must be in O(n).
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> count = new HashSet<>();
        if (nums.length <= 3) return nums[nums.length - 1];
        for (int i = nums.length; i >= 0; --i) {
            count.add(nums[i]);
            if (count.size() == 3) return nums[i];
        }
        return nums[nums.length - 1];
    }
}
