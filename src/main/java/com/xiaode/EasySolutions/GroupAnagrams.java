package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Jul, 2018
 *
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * first time exceed
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();

        for (String str : strs) {
            //first string
            boolean isAdded = false;
            if (results.size() == 0) {
                List<String> group = new ArrayList<>();
                group.add(str);
                results.add(group);
                continue;
            }

            //iterate the existing group
            for (List<String> list: results){
                if (checkAnagrams(list.get(0),str)) {
                    list.add(str);
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                List<String> groupNew = new ArrayList<>();
                groupNew.add(str);
                results.add(groupNew);
            }

        }

        return results;
    }

    /**
     * Helper function, check if 2 strings are anagram
     * @param s1
     * @param s2
     * @return
     */
    private boolean checkAnagrams(String s1, String s2) {
        HashMap<Character,Integer> counter = new HashMap<>();
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            //s1
            if (counter.get(s1.charAt(i)) ==  null) {
                counter.put(s1.charAt(i), 1);
            } else {
                counter.put(s1.charAt(i), counter.get(s1.charAt(i))+1);
            }

            //s2
            if (counter.get(s2.charAt(i)) == null) {
                counter.put(s2.charAt(i), -1);
            }else {
                counter.put(s2.charAt(i), counter.get(s2.charAt(i))-1);
            }
        }

        for(Character characters: counter.keySet()) {
            if (counter.get(characters) != 0) return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String canonical = getCanonical(str);
            List<String> list = map.get(canonical);
            if(list==null){
                list = new LinkedList<>();
                map.put(canonical, list);
            }
            list.add(str);
        }
        return new LinkedList(map.values());
    }

    /**
     * All Strings can be converted into a canonical form. This canonical form
     * will be same for Strings that are Anagrams of each other.
     * To do this, we first count the occurence of each alphabet & store it in charCount.
     * We then generate the canonical form which contains all alphabets that occured atleast once
     * followed by the number of times they occurred.
     * For eg:
     * eat -> a1e1t1
     * tan -> a1n1t1
     * bully -> b1l2u1y1
     */
    private String getCanonical(String str){
        StringBuilder builder = new StringBuilder();
        int [] charCount = new int[26];
        for(char c : str.toCharArray()){
            charCount[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(charCount[i]>0){
                builder.append((char)('a'+i));
                builder.append(charCount[i]);
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] test = {"eat","tea","tan","ate","nat","bat"};

        double start;
        double end;

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++){
            g.groupAnagrams(test);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms\n");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++){
            g.groupAnagrams2(test);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms\n");
    }
}
