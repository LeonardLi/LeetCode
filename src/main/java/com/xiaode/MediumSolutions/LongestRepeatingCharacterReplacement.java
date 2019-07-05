package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 *
 * 424.Longest Repeating Character Replacement
 *
 * Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the
 * length of a longest substring containing all repeating letters you can get after performing the above operations.e
 */
public class LongestRepeatingCharacterReplacement {
    //slicing window !!!
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int [] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end)-'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start)-'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
