package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 4/5/17.
 *
 * 400. Nth Digit
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * We need to find out following info to locate a digit:
 *
 * Which number is it in?
 * Which digits is this number
 * We can easily observe that:
 * digits in numbers with 1 digit: 9
 * digits in numbers with 2 digit: (99 - 9) * 2
 * digits in numbers with 3 digit: (999 - 90 - 9) * 3
 * digits in numbers with n digit: 9 * Math.pow(10, n - 1) * n
 *
 * By keep deducting the digits inside number-with-n-digit we can get a residual (n) which means "the n th digit of
 * number-with-k-digits".And by using that we can locate the number and the exact digit index
 */
public class NthDigit {

    public int findNthDigit(int n){
        // Get the number of digits
        int digits = 1;

        // The interval size of current digit
        long interval = digits * 9 * (long) Math.pow(10, digits - 1);

        int start = 1;

        while (n > interval){
            n -= interval;
            start += interval / digits;
            digits++;
            interval = digits * 9 * (long) Math.pow(10, digits - 1);
        }

        // The number we should get the digit from
        start += (n - 1) / digits;

        // How many times we need to divide to get the digit
        int time = digits - 1 - (n - 1) % digits;

        for (int i = 0; i < time; i++){
            start /= 10;
        }
        return start % 10;

    }
}
