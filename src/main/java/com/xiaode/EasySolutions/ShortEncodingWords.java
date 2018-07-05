package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Jul, 2018
 *
 * 820. Short Encoding of Words
 *
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 *
 * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
 *
 * Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.
 *
 * What is the length of the shortest reference string S possible that encodes the given words?
 *
 * Note:
 *
 * 1 <= words.length <= 2000.
 * 1 <= words[i].length <= 7.
 * Each word has only lowercase letters.
 *
 * Totally no idea
 *
 * Using Trie
 */
public class ShortEncodingWords {

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        List<TrieNode> leaves = new ArrayList<>();
        for (String s : new HashSet<>(Arrays.asList(words))) {
            TrieNode current = root;
            for (int i = s.length() - 1; i >= 0; --i) {
                char j = s.charAt(i);
                if (!current.next.containsKey(j)) current.next.put(j, new TrieNode());
                current = current.next.get(j);
            }
            current.depth = s.length() + 1;
            leaves.add(current);
        }

        int res = 0;
        for (TrieNode leaf : leaves) if (leaf.next.isEmpty()) res += leaf.depth;

        return res;
    }

    class TrieNode {
        HashMap<Character, TrieNode> next = new HashMap<>();
        int depth;
    }

    public static void main(String[] args) {
        ShortEncodingWords s = new ShortEncodingWords();
        String[] test = {"time", "me", "bell"};
        s.minimumLengthEncoding(test);
    }
}
