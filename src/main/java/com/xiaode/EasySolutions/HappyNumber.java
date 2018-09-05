package com.xiaode.EasySolutions;

import java.util.HashSet;

/**
 * Created by liyangde on Sep, 2018
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by
 *
 * the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops
 *
 * endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 */

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> count = new HashSet<>();
        while (n != 1) {
            String number = String.valueOf(n);
            int sum = 0;
            for (char c : number.toCharArray()) {
                sum += (c - '0') * (c - '0');
            }
            if (count.contains(sum)) return false;
            count.add(sum);
            n = sum;
        }
        return true;

    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        happyNumber.isHappy(19);
    }

}
