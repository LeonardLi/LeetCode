package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 367. Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 0 ) return true;
        if (sqrt(num) * sqrt(num) != num) return false;
        return true;

    }
    private int sqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
