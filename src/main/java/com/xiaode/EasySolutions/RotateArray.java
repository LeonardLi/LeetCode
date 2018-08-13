package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 189. Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) k = k % nums.length;
        if (nums.length == 1) return;
        int[] temp = new int[nums.length];

        for (int i = nums.length - k,j = 0; i < nums.length; i++, j++) {
            temp[j] = nums[i];
        }
        for (int i = 0,j = k; i < nums.length - k; i++, j++ ) {
            temp[j] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
        return;
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] test = {1,2,3,4,5,6,7};
        ra.rotate(test, 2);
    }
}
