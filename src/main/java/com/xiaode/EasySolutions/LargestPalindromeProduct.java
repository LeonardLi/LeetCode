package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 479. Largest Palindrome Product
 *
 * Find the largest palindrome made from the product of two n-digit numbers.
 *
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 *
 * Example:
 *
 * Input: 2
 *
 * Output: 987
 *
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 *
 * Note:
 *
 * The range of n is [1,8].
 */
public class LargestPalindromeProduct {

    public int largestPalindrome(int n) {
        long max = (long)Math.pow(10, n) - 1;
        long min = max / 10;

        for (long h = max; h > min; h--) {
            long left = h, right = 0;
            for (long i = h; i != 0; right = right * 10 + i % 10, i /= 10, left *= 10);
            long palindrom = left + right;      // construct the palindrome

            for (long i = max; i > min; i--) {
                long j = palindrom / i;
                if (j > i) break;     // terminate if the other number is greater than current number
                if (palindrom % i == 0) return (int)(palindrom % 1337); // found if current number is a factor
            }
        }

        return 9;    // account for case n = 1
    }
}
