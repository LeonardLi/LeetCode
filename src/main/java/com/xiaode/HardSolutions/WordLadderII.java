package com.xiaode.HardSolutions;

import java.util.*;

/**
 * 126. Word Ladder II
 * <p>
 * Created by liyangde on Feb, 2019
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: []
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadderII {

    List<List<String>> results;
    List<String> list;
    Map<String, List<String>> map;

    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        if (!dict.contains(end)) return new ArrayList<>();
        results = new ArrayList<>();
        if (dict.size() == 0)
            return results;

        int curr = 1, next = 0;
        boolean found = false;
        list = new LinkedList<>();
        map = new HashMap<>();

        Queue<String> queue = new ArrayDeque<>();
        Set<String> unvisited = new HashSet<>(dict);
        Set<String> visited = new HashSet<>();

        queue.add(start);
        unvisited.add(end);
        unvisited.remove(start);
        //BFS
        while (!queue.isEmpty()) {

            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String new_word = builder.toString();
                    if (unvisited.contains(new_word)) {
                        //Handle queue
                        if (visited.add(new_word)) {//Key statement,Avoid Duplicate queue insertion
                            next++;
                            queue.add(new_word);
                        }

                        if (map.containsKey(new_word))//Build Adjacent Graph
                            map.get(new_word).add(word);
                        else {
                            List<String> l = new LinkedList<String>();
                            l.add(word);
                            map.put(new_word, l);
                        }

                        if (new_word.equals(end) && !found) found = true;

                    }

                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
            if (curr == 0) {
                if (found) break;
                curr = next;
                next = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While

        backTrace(end, start);

        return results;
    }

    private void backTrace(String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null)
            for (String s : map.get(word))
                backTrace(s, start);
        list.remove(0);
    }
}
