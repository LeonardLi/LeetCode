package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 680. Valid Palindrome II
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        String s1;

        int index = checkPalindrome(s);
        if (index == -1) return true;
        else {
            //remove head
            s1 = s.substring(0,index)+s.substring(index+1);
            if (checkPalindrome(s1) == -1) {
                return true;
            } else {
                //remove tail
                s1 = s.substring(0,s.length() - index - 1) + s.substring(s.length() - index); //watch out the index!!!
                if (checkPalindrome(s1) ==  -1) return true;
            }

            return false;
        }
    }

    /**
     * Check whether the string s is the palindrome, return the index of the character
     * @param s
     * @return -1 means palindrome
     */
    public int checkPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end) ) {
                return start;
            }
            start++;
            end--;
        }
        return -1;
    }

    public static void main(String[] args) {
        ValidPalindromeII v = new ValidPalindromeII();
        String s = "cbbcc";
        v.validPalindrome(s);
    }
}
