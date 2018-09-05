package com.xiaode.EasySolutions;



/**
 * Created by liyangde on Sep, 2018
 *
 * Given an integer, return its base 7 string representation.
 *
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class Base7 {

    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isNegetive = num < 0;
        if (isNegetive) {
            num = -num;
        }
        while(num >= 7) {
            sb.append(num % 7);
            num = num / 7;
        }
        sb.append(num);
        return isNegetive ? "-" + sb.reverse().toString() : sb.reverse().toString();
    }

    public String convertToBase7II(int num){
        return Integer.toString(num, 7);
    }
}
