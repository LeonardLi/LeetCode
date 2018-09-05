package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 744. Find Smallest Letter Greater Than Target
 *
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 *
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 *
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1] || target < letters[0]) return letters[0];
        // can be more quick by using binary search
        for (char c : letters) {
            if (c > target) return c;
        }
        return letters[0];
    }
}
