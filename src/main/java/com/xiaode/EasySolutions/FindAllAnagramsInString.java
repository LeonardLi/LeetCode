package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangde on Aug, 2018
 *
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 */
public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return Collections.emptyList();
        for(int i = 0; i < s.length() - p.length(); i++) {
            if (checkAnagrams(p, s.substring(i, i + p.length()))) list.add(i);
        }
        return list;
    }

    private boolean checkAnagrams(String s1, String s2) {
        int [] dic = new int[26];
        for (char c : s1.toCharArray()) {
            dic[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            dic[c - 'a']--;
        }

        for (int i : dic) {
            if (i != 0) return false;
        }
        return true;
    }
}
