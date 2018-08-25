package com.xiaode.EasySolutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyangde on Aug, 2018
 *
 * 263. Ugly Number
 *
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 *
 *
 */
public class UglyNumber {
    //too slow
    public boolean isUgly(int num) {
        Set<Integer> factors = new HashSet<>();
        if (num < 0) return false;
        checkPrime(num, factors);
        factors.remove(2);
        factors.remove(3);
        factors.remove(5);
        return factors.isEmpty();
    }

    private Set<Integer> checkPrime(int num, Set<Integer> factors) {
        int i = 2;
        while (i <= num) {
            if (num % i == 0) {
                factors.add(i);
                num = num / i;
                i = 2;
            } else {
                i++;
            }
        }
        return factors;
    }

    public boolean isUgly2(int num){
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        un.isUgly(905391974);
    }
}
