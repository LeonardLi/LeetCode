package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 4/4/17.
 */
public class LengthofLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters
     * ' ', return the length of last word in the string.
     * If the last word does not exist return 0
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if(s.equals("")) return 0;
        if(s.trim().equals("")) return 0;
        if(!s.contains(" ")) return s.length();
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }
}
