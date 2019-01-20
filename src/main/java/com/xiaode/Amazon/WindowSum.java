package com.xiaode.Amazon;

/**
 * Created by liyangde on Jan, 2019
 */
public class WindowSum {
    public int[] sum(int[] nums, int window) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (nums.length <= window) {
            return nums;
        }
        int sum = 0;
        int index = 0;
        int[] result = new int[nums.length - window + 1];

        for (int i = 0; i < window; i++) {
            sum += nums[i];
        }
        result[index++] = sum;
        for (int i = window; i < nums.length; i++) {
            sum -= nums[i - window];
            sum += nums[i];
            result[index++] = sum;
        }
        return result;
    }
}
