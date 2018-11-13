package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 *
 * 243. Shortest Word Distance
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = words.length;
        int pointer1 = -1;
        int pointer2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)){
                pointer1 = i;
            }else if (words[i].equals(word2)){
                pointer2 = i;
            }

            if(pointer1 != -1 && pointer2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(pointer1-pointer2));
            }
        }
        return minDistance;
    }


}
