package com.xiaode.Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liyangde on May, 2019
 */
public class LongestStringChain {
    int res = Integer.MIN_VALUE;
    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> dic = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(String word :words){
            List<String> list = dic.getOrDefault(word.length(), new ArrayList<>());
            list.add(word);
            dic.put(word.length(), list);
            max = Math.max(max, word.length());
        }
        helper(1, " ", 0, dic, max);
        return res;
    }
    private void helper(int level, String pre , int temp, Map<Integer, List<String>> dic, int maxLength) {
        if(dic.get(level) == null) {
            res = Math.max(res, temp);
            //end
            if (level >= maxLength) return;
            // not end
            else helper(level+1, " ",0 ,dic, maxLength);
        } else {
            List<String> words = dic.get(level);
            //System.out.println(level);
            List<String> nList = new ArrayList<>();
            for (String word : words) {
                if(pre.equals(" ") || isPredecessor(word, pre) ) {
                    helper(level+1, word, temp+1, dic, maxLength);
                } else {
                    res = Math.max(res, temp);
                    //helper(level+1, word, 1, dic, maxLength);
                    nList.add(word);
                }
            }
            for (String n : nList) {
                helper(level+1, n, 1, dic, maxLength);
            }
        }
    }
    private boolean isPredecessor(String s1, String s2){
        int[] a = new int[26];
        for(char c : s1.toCharArray()) {
            a[c-'a']++;
        }
        for (char c: s2.toCharArray()) {
            a[c-'a']--;
        }
        int count = 0;
        for(int v : a) {
            if(v != 0) count++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        LongestStringChain l = new LongestStringChain();
        int res = l.longestStrChain(new String[]{"sgtnz","sgtz","sgz","ikrcyoglz","ajelpkpx","ajelpkpxm","srqgtnz","srqgotnz","srgtnz","ijkrcyoglz"});
        System.out.println(res);
    }
}
