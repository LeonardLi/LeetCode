package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Oct, 2018
 * 692. Top K Frequent Words
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        List<String>[] buckets = new List[words.length + 1];
        for (int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();

        for (String key : map.keySet()) buckets[map.get(key)].add(key);
        for (int i = words.length; i >= 0; i--) {
            if (buckets[i].size() == 0) continue;
            res.addAll(buckets[i]);
            if (res.size() >= k) break;
        }
        return res;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k) pq.poll();
        }

        while(!pq.isEmpty()) result.add(0, pq.poll().getKey());

        return result;
    }
}
