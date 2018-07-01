package com.xiaode.EasySolutions;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // for single digit
        if (x < 0) return false;
        if (x < 10) return true;
        //transfer to string to handle
        String num = String.valueOf(x);
        if (x < 0) num = num.substring(1);
        int cursor = 0;
        while(cursor < num.length()/2) {
            if(num.charAt(cursor) != num.charAt(num.length() - cursor - 1)) return false;
            cursor++;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        p.isPalindrome(-2147447412);
    }

}
