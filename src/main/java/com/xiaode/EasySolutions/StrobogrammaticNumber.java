package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 *
 * 246. Strobogrammatic Number
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * Example 1:
 *
 * Input:  "69"
 * Output: true
 * Example 2:
 *
 * Input:  "88"
 * Output: true
 * Example 3:
 *
 * Input:  "962"
 * Output: false
 */
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        int start = 0;
        int end = num.length() - 1;
        while (start <= end) {
            switch(num.charAt(start)) {
                case '0':
                case '1':
                case '8':
                    if (num.charAt(end) != num.charAt(start)) {
                        return false;
                    }
                    break;
                case '6':
                    if (num.charAt(end) != '9') {
                        return false;
                    }
                    break;
                case '9':
                    if (num.charAt(end) != '6') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
