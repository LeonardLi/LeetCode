package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 69. Sqrt(x)
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 */
public class Sqrtx {

    // too slow
    public int mySqrt(int x) {
        for (int i = 0; ;i++) {
            if (i * i < x ) continue;
            if (i * i == x) return i;
            if (i * i > x) return i - 1;
        }
    }

    //Newton's way
    public int mySqrt2(int x) {
        double err = 1e-15;
        int t = x ;
        while (Math.abs(t - x / t) > err * t){
            t = (x/t + t) / 2;
        }
        return t;

    }


    // binary search
    public int sqrt(int x) {
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
