package com.xiaode.EasySolutions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liyangde on Jul, 2018
 */
public class ValidPalindrome {
    /**
     * 125. Valid Palindrome
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     */
    //

    public boolean isPalindrome(String s) {
        //S1. trim and simplify the string
        //S2. judge if palindrome
        String newString = "";

        //corner case
        if (s.length() <= 1) return true;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)<='Z' && s.charAt(i)>='A' ||
                    s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
                    s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                newString += Character.toLowerCase(s.charAt(i));
            }
        }
        System.out.println(newString);
//
        for (int i = 0; i < newString.length()/2; i++){
            if (newString.charAt(i) != newString.charAt(newString.length()-i-1)) return false;
        }
       return true;

    }
    //11ms
    public boolean isPalindrome1(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                ++i;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                --j;
            }
            if(i<j){
                if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                ++i;
                --j;
            }

        }
        return true;

    }

    //35ms
    public boolean isPalindrome2(String s){
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }




    public static void main(String[] args){
        ValidPalindrome v = new ValidPalindrome();
        String test = "A man, a plan, a canal: Panama";
        System.out.println(v.isPalindrome(test));
    }
}
