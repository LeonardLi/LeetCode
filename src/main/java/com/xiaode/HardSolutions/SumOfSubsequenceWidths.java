package com.xiaode.HardSolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Sep, 2018
 *
 * 891. Sum of Subsequence Widths
 *
 * Given an array of integers A, consider all non-empty subsequences of A.
 *
 * For any sequence S, let the width of S be the difference between the maximum and minimum element of S.
 *
 * Return the sum of the widths of all subsequences of A.
 *
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: [2,1,3]
 * Output: 6
 * Explanation:
 * Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
 * The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
 * The sum of these widths is 6.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 20000
 */
public class SumOfSubsequenceWidths {

    public int sumSubseqWidths(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; i++) {
            pow2[i] = pow2[i-1] * 2 % MOD;
        }

        long ans = 0;
        for (int i = 0; i < N; ++i) {
            ans = (ans + (pow2[i] - pow2[N-1-i]) * A[i] ) % MOD;
        }
        return (int) ans;
    }


    /**
     * The order in initial arrays doesn't matter,
     * my first intuition is to sort the array.
     *
     * For A[i]:
     * There are i smaller numbers,
     * so there are 2 ^ i sequences in which A[i] is maximum.
     * we should do res += A[i] * (2 ^ i)
     *
     * There are n - i - 1 bigger numbers,
     * so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
     * we should do res -= A[i] * 2 ^ (n - i - 1)
     *
     * Q. why do we plus mod before return?
     * A: in Cpp and Java, mod on negative number will still get a negative number.
     */
    public int sumSubseqWidths2(int[] A) {
        Arrays.sort(A);
        long c = 1, res = 0, mod = (long)1e9 + 7;
        for (int i = 0; i < A.length; ++i, c = (c << 1) % mod)
            res = (res + A[i] * c - A[A.length - i - 1] * c) % mod;
        return (int)((res + mod) % mod);
    }
}
