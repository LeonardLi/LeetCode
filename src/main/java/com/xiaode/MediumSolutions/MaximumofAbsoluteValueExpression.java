package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 *
 * 1131. Maximum of Absolute Value Expression
 *
 * Given two arrays of integers with equal lengths, return the maximum value of:
 *
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 *
 * where the maximum is taken over all 0 <= i, j < arr1.length.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * Output: 13
 * Example 2:
 *
 * Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * Output: 20
 *
 *
 * Constraints:
 *
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 */
public class MaximumofAbsoluteValueExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = Integer.MIN_VALUE;
        for(int i = -1; i <=1; i+=2) {
            for(int j = -1; j <=1; j+=2) {
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for(int k = 0; k < arr1.length; k++) {
                    max = Math.max(max, arr1[k]*i+arr2[k]*j+k);
                    min = Math.min(min, arr1[k]*i+arr2[k]*j+k);
                }
                res = Math.max(max - min, res);
            }
        }
        return res;
    }
}
