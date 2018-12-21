package com.xiaode.MediumSolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Nov, 2018
 *
 * 313. Super Ugly Number
 *
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 *
 * Example:
 *
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 *              super ugly numbers given primes = [2,7,13,19] of size 4.
 * Note:
 *
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int []superUgly = new int[n];
        int []indexes = new int[primes.length];
        int []temp = Arrays.copyOf(primes,primes.length);
        superUgly[0] = 1;
        for (int i = 1; i < n; i++) {
            int res[] = findMin(temp);
            if (res[0] != superUgly[i-1]) {
                superUgly[i] = res[0];
            }else {
                i = i-1;
            }
            temp[res[1]] = primes[res[1]] * superUgly[++indexes[res[1]]];
        }
        System.out.println(Arrays.toString(superUgly));
        return superUgly[n-1];
    }

    private int[] findMin(int[] primes){
        int [] res = new int[2];
        res[0] = Integer.MAX_VALUE;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] < res[0]) {
                res[0] = primes[i];
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        superUglyNumber.nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }
}
