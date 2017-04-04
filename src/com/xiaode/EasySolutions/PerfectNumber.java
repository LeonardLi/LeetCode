package com.xiaode.EasySolutions;

import java.util.ArrayList;

/**
 * Created by xiaode on 4/4/17.
 */
public class PerfectNumber {
    /**
     * 507. Perfect Number
     * We define the Perfect NUmber is a positive integer that is equal to the sum of all its positive
     * divisors except itself. Now, given an integer n, write a function that returns true when it is
     * a perfect number and false when it is not
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return true;
        int result = 0;
        ArrayList<Integer> divisors = helper(num);
        for (int i : divisors) {
            result += i;
        }
        if(result == num) return true;
        return false;
    }
    private ArrayList<Integer> helper(int num) {
        ArrayList<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        int n = (int)Math.sqrt(num);
        for (int i = 2; i <= n ;i++) {
            if(num % i == 0) {
                divisors.add(i);
                divisors.add(num/i);
            }
        }
        return divisors;
    }
}

