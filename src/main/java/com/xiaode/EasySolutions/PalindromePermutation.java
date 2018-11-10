package com.xiaode.EasySolutions;

import java.util.HashMap;

/**
 * Created by liyangde on Oct, 2018
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        boolean isEvenLength = s.length() % 2 == 0;
        boolean hasOddNumber = false;
        for (Character c : map.keySet()) {
            if (isEvenLength) {
                if (map.get(c) % 2 != 0) return false;
            } else {
                if (map.get(c) % 2 != 0) {
                    if (!hasOddNumber) {
                        hasOddNumber = true;
                    } else {
                        return  false;
                    }
                }
            }
        }
        return true;
    }
}
