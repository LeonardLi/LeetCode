package com.xiaode.EasySolutions;

/**
 * 1309. Decrypt String from Alphabet to Integer Mapping
Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.
 */

public class DecryptString {

    static char [] dic = new char[]{'a','b','c','d','e', 'f', 'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0;) {
            int ss;
            if (s.charAt(i) == '#') {
                // read 3
                ss = s.charAt(i-1)-'0' +( s.charAt(i-2) -'0')* 10;
            
                i-=3;
            } else {
                // read 1
                ss = s.charAt(i)-'0';
                i--;
            }
            sb.append(dic[ss-1]);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
        
    }
}
