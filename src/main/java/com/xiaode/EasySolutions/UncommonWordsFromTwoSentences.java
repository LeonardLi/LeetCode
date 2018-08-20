package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liyangde on Aug, 2018
 *
 * 884. Uncommon Words from Two Sentences
 *
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 * Note:
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 *
 *
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        String [] strA = A.split(" ");
        String [] strB = B.split(" ");
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();

        for (String str : strA) {
            if (count.containsKey(str)) {
                count.put(str, count.get(str) + 1);
            } else {
                count.put(str, 1);
            }

        }
        for (String str : strB) {
            if (count.containsKey(str)) {
                count.put(str, count.get(str) + 1);
            } else {
                count.put(str, 1);
            }

        }

        for (String str : count.keySet()) {
            if (count.get(str) > 1) result.add(str);
        }

        return result.toArray(new String[0]);
    }
}
