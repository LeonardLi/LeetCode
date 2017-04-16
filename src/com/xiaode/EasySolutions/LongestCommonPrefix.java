package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 4/4/17.
 */


/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amonst an array of strings
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
