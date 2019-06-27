package com.xiaode.ADT;

import java.util.Arrays;

/**
 * Created by liyangde on May, 2019
 */
public class DPTest {
    public int maxProfit(int[] p) {
        int[] dp = new int[p.length+1];
        dp[0] = 0;
        for(int i = 1; i < p.length+1;i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i-j-1]+p[j], dp[i]);
            }
        }
        return dp[p.length];
    }

    public int maxJob(int[] l, int[] s, int d) {
        int[] dp = new int[l.length+1];
        dp[0] = 0;
        for(int i = 1; i <= d; i++) {
            if (i == 1) dp[i] = s[1];
            else {
                dp[i] = Math.max(dp[i-1]+s[i], dp[i-2]+l[i-1]);
            }
        }
        return dp[d];
    }

    public static void main(String[] args) {
        DPTest test = new DPTest();
        System.out.println(test.maxProfit(new int[]{1,3,4}));

    }






}
