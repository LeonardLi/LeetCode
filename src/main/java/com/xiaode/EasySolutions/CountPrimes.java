package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 204. Count Primes
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {
    private int[] dp;
    public int countPrimes(int n) {
        dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n-1];
    }
    private boolean isPrime(int n){
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //very cool
    public int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true; // expand
                }
            }
        }

        return count;
    }
}
