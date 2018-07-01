package com.xiaode.EasySolutions;

/**
 * Created by leonard on 25/02/2017.
 */
public class DetectCapital2 {
    /**
     * 520.Detect Capital
     * Given a word, you need to judge whether the usage of capitals in it is right or not.
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     * 1.All letters in this word are capitals, like "USA".
     * 2.All letters in this word are not capitals, like "leetcode".
     * 3.Only the first letter in this word is capital if it has more than one letter, like "Google".
     */

    public boolean detectCapitalUse(String word){
        if (word == null) return false;
        if (word.length() == 1) return true;
        if (word.charAt(0)<='Z') {
            if (word.charAt(1)>='a') {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i)<='Z') {
                        return false;
                    }
                }
                return true;
            }else{
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i)>='a') {
                        return false;
                    }
                }
                return true;
            }

        }
        if (word.charAt(0)<='z' && word.charAt(0)>='a') {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i)<='Z') {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
