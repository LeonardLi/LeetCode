package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Oct, 2018
 *
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    //TLE
    int shortest = 0;
    //DFS way
    HashMap<String, ArrayList<String>> storage = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> set = new HashSet<>();
        wordList = new ArrayList<>(wordList);
        if (!wordList.contains(endWord)) return 0;
        set.add(beginWord);
        return helper(beginWord, endWord, set, wordList, 1);
    }
    private int helper(String beginWord, String endWord, Set<String> visited,List<String> wordList, int path){
        if (checkDifference(beginWord, endWord)) {
            if (shortest == 0) {
                shortest = path+1;
            } else {
                shortest = Math.min(shortest, path+1);
            }
            return shortest;
        }
        int res = 0;
        for (String word : wordList) {
            if (checkDifference(beginWord, word) && !visited.contains(word)) {
                visited.add(word);
                helper(word, endWord, visited, wordList, path+1);
                visited.remove(word);
            }
        }
        return shortest;
    }

    private boolean checkDifference(String a, String b) {
        if (storage.get(a) != null) {
            if (storage.get(a).contains(b)) return true;
        } else {
            storage.put(a, new ArrayList<>());
        }
        int dif = 0;
        for (int i = 0; i < a.length(); i++ ) {
            if (a.charAt(i) != b.charAt(i)) dif++;
        }
        if (dif == 1) {
            storage.get(a).add(b);
        }
        return dif == 1 ? true : false;
    }

    //accepted
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        ArrayDeque<String> current = new ArrayDeque<>();
        ArrayDeque<String> next = new ArrayDeque<>();
        HashSet<String> wordSets = new HashSet<>(wordList);
        if (!wordSets.contains(endWord)) return 0;

        current.push(beginWord);
        int level = 1;
        while (current.size() != 0) {
            level++;
            while (current.size() != 0) {
                String temp = current.poll();
                for (Iterator<String> it = wordSets.iterator(); it.hasNext();) {
                    String word = it.next();
                    if (checkDifference(word, temp)) {
                        it.remove();
                        if (word.equals(endWord)) return level;
                        next.push(word);
                    }
                }

            }
            current = next;
            next = new ArrayDeque<>();
        }
        return 0;
    }

    public static void main(String[] args){
        WordLadder wordLadder = new WordLadder();

        System.out.println(wordLadder.ladderLength("teach", "place", Arrays.asList("peale","wilts","place","fetch","purer","pooch","peace","poach","berra","teach","rheum","peach")));
    }
}
