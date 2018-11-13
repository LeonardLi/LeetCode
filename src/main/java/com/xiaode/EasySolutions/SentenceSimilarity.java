package com.xiaode.EasySolutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyangde on Nov, 2018
 */
public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null) return false;
        if(words1.length != words2.length) return false;
        HashMap<String, Set<String>> map = new HashMap<>();

        for(String[] pair : pairs) {

            if(map.containsKey(pair[0])){
                map.get(pair[0]).add(pair[1]);
            } else {
                Set<String> set = new HashSet<>();
                set.add(pair[1]);
                set.add(pair[0]);
                map.put(pair[0], set);
            }

            if(map.containsKey(pair[1])){
                map.get(pair[1]).add(pair[0]);
            } else {
                Set<String> set = new HashSet<>();
                set.add(pair[1]);
                set.add(pair[0]);
                map.put(pair[0],set);
            }
        }

        for (int i = 0;i < words1.length; i++) {

        }
        return true;
    }
}
