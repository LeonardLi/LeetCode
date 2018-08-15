package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int result = 0;
        boolean isContainSingle = false;
        int[] dic = new int[200];
        for (char c : s.toCharArray()) {
            dic[c]++;
        }
        for (int i = 32; i < 200; i++) {
            if (dic[i] > 0){
                if (dic[i] % 2 == 0) result += dic[i];
                else {
                    if (dic[i] > 2) result += dic[i] - 1;
                    isContainSingle = true;
                }
            }
        }

        return isContainSingle ? result+1 : result;

    }
}
