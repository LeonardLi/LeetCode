package com.xiaode.HardSolutions;

import java.util.*;

/**
 * Created by liyangde on Feb, 2019
 * <p>
 * 269. Alien Dictionary
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        HashSet[] graph = new HashSet[26];
        Map<Integer, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                degree.put(ch - 'a', 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            int k = 0;

            while (k < len) {
                char ch1 = w1.charAt(k);
                char ch2 = w2.charAt(k);
                if (ch1 != ch2) {
                    if (graph[ch1 - 'a'] == null) {
                        graph[ch1 - 'a'] = new HashSet<Integer>();
                    }
                    if (graph[ch1 - 'a'].add(ch2 - 'a'))
                        degree.put(ch2 - 'a', degree.getOrDefault(ch2 - 'a', 0) + 1);

                    break;
                }
                k++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int node : degree.keySet()) {
            if (degree.get(node) == 0) queue.offer(node);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append((char) ('a' + node));

            HashSet<Integer> connect = graph[node];

            if (connect == null) continue;
            for (int next : connect) {
                int nextDegree = degree.get(next) - 1;
                if (nextDegree == 0) {
                    degree.put(next, 0);
                    queue.offer(next);
                } else {
                    degree.put(next, nextDegree);
                }

            }
        }
        if (sb.length() != degree.size()) return "";
        return sb.toString();
    }


}
