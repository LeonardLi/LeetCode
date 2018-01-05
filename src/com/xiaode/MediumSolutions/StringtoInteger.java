package com.xiaode.MediumSolutions;


/**
 * 8. String to Integer (atoi)
 * Implement atoi to convert a string to an integer
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        int result = 0;
        int radix = 10;
        str = str.trim();
        int len = str.length();
        boolean isNegative = false;
        //check input
        if (str == null || str.length() == 0) return 0;

        //check if number
        //check if single '-'
        if ( str.charAt(0) == '-' && str.length() < 2) return 0;

        for(int i = 0; i < str.length(); i++) {
            if(i == 0 && str.charAt(0) == '-') {
                isNegative = true;
                continue;
            }
            if (str.charAt(i) > '9' || str.charAt(i) < '0')
                return 0;
        }
        //convert
        //check if overflow -2147483648 2147483647
        int i = isNegative ? 1 : 0;
        while (i < len) {
            //if (Integer.MAX_VALUE)
            result += str.charAt(i);

        }
        return result;
    }
}
