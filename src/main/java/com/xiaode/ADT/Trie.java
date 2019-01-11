package com.xiaode.ADT;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyangde on Sep, 2018
 */
public class Trie {
    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }


    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    class TrieNode {
        // R links to node children
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }


    //677. Map Sum Pairs
    class MapSum {
        class TrieNode {
            Map<Character, TrieNode> children;
            boolean isWord;
            int value;

            public TrieNode() {
                children = new HashMap<>();
                isWord = false;
                value = 0;
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode curr = root;
            for (char c : key.toCharArray()) {
                TrieNode next = curr.children.get(c);
                if (next == null) {
                    next = new TrieNode();
                    curr.children.put(c, next);
                }
                curr = next;
            }
            curr.isWord = true;
            curr.value = val;
        }

        public int sum(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                TrieNode next = curr.children.get(c);
                if (next == null) {
                    return 0;
                }
                curr = next;
            }

            return dfs(curr);
        }

        private int dfs(TrieNode root) {
            int sum = 0;
            for (char c : root.children.keySet()) {
                sum += dfs(root.children.get(c));
            }
            return sum + root.value;
        }
    }

}
