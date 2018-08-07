package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 868. Binary Gap
 *
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 *
 * If there aren't two consecutive 1's, return 0.
 *
 *
 * Note:
 *
 * 1 <= N <= 10^9
 *
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }
}
