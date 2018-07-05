package com.xiaode.EasySolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Jul, 2018
 *
 * 611. Valid Triangle Number
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array
 *
 * that can make triangles if we take them as side lengths of a triangle.
 *
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 *
 * Naive solution exceed time limit
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int res = 0;

        //corner case
        if (nums.length < 3) return 0;

        if (nums.length == 3) return checkTriangle(nums[0],nums[1],nums[2]) ? 1:0;

        for (int i = 0; i < nums.length - 2; i++ ) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (checkTriangle(nums[i],nums[j],nums[k])) res ++;
                }
            }
        }
        return res;
    }

    //better in time
    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i=2;i<nums.length;i++) {
            int l = 0, r = i-1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r-l;//关键 例如 4568  i=8 r=6（index2） l=4（index0）此时 代表i和l r中一个不动 组成的个数
                    r--;//满足向左继续找
                }
                else l++;//不够大 向右找
            }
        }
        return count;
    }

    private boolean checkTriangle(int a, int b, int c) {
        if (!(a + b > c && a + c > b && c + b > a)) return false;
        return true;
    }
}

