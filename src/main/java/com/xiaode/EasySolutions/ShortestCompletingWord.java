package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Nov, 2018
 *
 * 748. Shortest Completing Word
 *
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate
 *
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 *
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 *
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 *
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * licensePlate will be a string with length in range [1, 7].
 * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> map = new HashMap();
        List<String> ans = new LinkedList<>();
        for (char c : licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                c = Character.toLowerCase(c);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        for (String word : words) {
            HashMap<Character, Integer> temp = (HashMap<Character, Integer>) map.clone();
            for (char c : word.toCharArray()) {
                if (temp.get(c) != null) {
                    temp.put(c, temp.get(c)-1);
                }
            }
            boolean isMatched = true;
            for (char c : temp.keySet()){
                if (temp.get(c) > 0) isMatched = false;
            }
            if (isMatched) ans.add(word);
        }
        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        return ans.get(0);
    }
}
