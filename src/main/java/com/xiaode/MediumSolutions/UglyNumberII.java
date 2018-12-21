package com.xiaode.MediumSolutions;

import java.util.TreeSet;

/**
 * Created by liyangde on Nov, 2018
 *
 * 264. Ugly Number II
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class UglyNumberII {



    //reuse UglyNumber I, TLE
    public int nthUglyNumber(int n) {
        int num = 1;
        for(int i = 1; i <=n;){
            if(isUgly(num)) i++;
            num++;
        }
        return num-1;
    }

    private boolean isUgly(int num) {
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }

    //
    public int nthUglyNumber2(int n) {
        TreeSet<Long> ans = new TreeSet<>();
        ans.add(1L);
        for (int i = 0; i < n - 1; ++i) {
            long first = ans.pollFirst();
            ans.add(first * 2);
            ans.add(first * 3);
            ans.add(first * 5);
        }
        return ans.first().intValue();
    }

    //fast
    public int nthUglyNumber3(int n) {
        int []ugly = new int [n];
        int a = 0,b = 0,c = 0;
        int fa = 2, fb = 3,fc =5;
        ugly[0] =1;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(fa,fb),fc);
            ugly[i] = min;
            if(fa == min)
                fa = 2*ugly[++a];
            if(fb == min)
                fb = 3*ugly[++b];
            if(fc == min)
                fc = 5*ugly[++c];
        }
        return ugly[n-1];
    }
}
