package com.xiaode.EasySolutions;

import java.util.Comparator;

/**
 * Created by liyangde on Dec, 2018
 */
public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for(int i = 0; i < 26; i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length -1; i++) {
            // words[i+1] > words[i]
            if (!check(words[i+1], words[i], orderMap)) return false;
        }
        return true;
    }

    private boolean check(String a, String b, int [] map) {
        int minLength = a.length() > b.length() ? b.length() : a.length();
        for (int i = 0; i < minLength; i++) {
            if (map[a.charAt(i)-'a'] > map[b.charAt(i)-'a']) return true;
            if (map[a.charAt(i)-'a'] < map[b.charAt(i)-'a']) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyingAlienDictionary v = new VerifyingAlienDictionary();
        System.out.println(v.isAlienSorted(new String[]{"word","world","row"},"worldabcefghijkmnpqstuvxyz"));
    }
}
