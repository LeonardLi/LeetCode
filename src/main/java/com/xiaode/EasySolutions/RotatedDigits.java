package com.xiaode.EasySolutions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 788. Rotated Digits
 *
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 *
 * Note:
 *
 * N  will be in range [1, 10000].
 *
 */
public class RotatedDigits {

    /**
     * Using a int[] for dp.
     * dp[i] = 0, invalid number
     * dp[i] = 1, valid and same number
     * dp[i] = 2, valid and different number
     * @param N
     * @return
     */
    public int rotatedDigits(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for(int i = 0; i <= N; i++){
            if(i < 10){
                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        RotatedDigits rotatedDigits = new RotatedDigits();
        System.out.println(rotatedDigits.rotatedDigits(10));
    }
}
