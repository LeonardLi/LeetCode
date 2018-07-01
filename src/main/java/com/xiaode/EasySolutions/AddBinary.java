package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 4/4/17.
 */

/**
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binarty string)
 */
public class AddBinary
{
    public String addBinary(String a , String b){
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0){
            int sum = ((i < 0) ? 0 : (a.charAt(i--) - '0')) +
                    ((j < 0) ? 0 : (b.charAt(j--) - '0')) +
                    carry;

            sb.append(Integer.toString(sum & 1));
            carry = (sum >> 1) & 1;
        }

        return sb.reverse().toString();
    }
}
