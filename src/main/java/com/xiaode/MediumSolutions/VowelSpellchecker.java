package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Dec, 2018
 */
public class VowelSpellchecker {
    class TrieNode {
        List<String> startWith;
        TrieNode[] children;
        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[128];
        }
    }
    class Trie{
        TrieNode root;
        List<Character> vowel = Arrays.asList('a','e', 'i','o','u','A','E','I','O','U');
        Trie(String[] words) {
            root = new TrieNode();
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'A';
                    if (cur.children[idx] == null) {
                        cur.children[idx] = new TrieNode();
                    }
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        String search(String word, Map<String, Integer> map) {
            String res = "";
            List<String> list = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            boolean[] exactly = new boolean[1];
            exactly[0] = true;
            searchHelper(word, root, 0, list, exactly, list2);
            if (list2.size() != 0) {
                res = list2.get(0);
            }else {
                int index = Integer.MAX_VALUE;
                for (String s : list) {
                    if (!s.equals("")) {
                        if (map.get(s) < index) {
                            res = s;
                            index = map.get(s);
                        }
                    }
                }
            }
            return res;
        }

        void searchHelper(String word, TrieNode node, int index, List<String> list, boolean[] exactly, List<String> exactlyList) {
            if (index == word.length()) {
                for (String s : node.startWith) {
                    if (s.length() == index) {
                        list.add(s);
                        if (exactly[0]) exactlyList.add(s);
                    }

                }
                return;
            } else {
                if (node.children[word.charAt(index)-'A'] == null) {
                    if (vowel.contains(word.charAt(index))){
                        // replace and find
                        for(Character ch : vowel) {
                            if (node.children[ch -'A'] != null) {
                                exactly[0] = false;
                                searchHelper(word, node.children[ch -'A'], index+1, list, exactly, exactlyList);
                            }
                        }
                    } else {
                        // not vowel, not match, try captital
                        if (Character.isUpperCase(word.charAt(index))) {
                            if (node.children[Character.toLowerCase(word.charAt(index))-'A'] != null) {
                                exactly[0] = false;
                                searchHelper(word, node.children[Character.toLowerCase(word.charAt(index))-'A'], index+1, list, exactly, exactlyList);
                            } else {
                                list.add(""); return;
                            }
                        } else {
                            if (node.children[Character.toUpperCase(word.charAt(index))-'A'] != null) {
                                exactly[0] = false;
                                searchHelper(word, node.children[Character.toUpperCase(word.charAt(index))-'A'], index+1, list, exactly, exactlyList);
                            } else {
                                list.add(""); return;
                            }
                        }
                    }

                } else{
                    // match
                    searchHelper(word, node.children[word.charAt(index)-'A'], index+1, list, exactly, exactlyList);
                    if(vowel.contains(word.charAt(index))) {
                        for(Character ch : vowel) {
                            if (node.children[ch -'A'] != null) {
                                exactly[0] = false;
                                searchHelper(word, node.children[ch -'A'], index+1, list, exactly, exactlyList);
                            }
                        }
                    }
                    if (Character.isUpperCase(word.charAt(index))) {
                        if (node.children[Character.toLowerCase(word.charAt(index))-'A'] != null) {
                            exactly[0] = false;
                            searchHelper(word, node.children[Character.toLowerCase(word.charAt(index))-'A'], index+1, list, exactly, exactlyList);
                        }
                    } else {
                        if (node.children[Character.toUpperCase(word.charAt(index))-'A'] != null) {
                            exactly[0] = false;
                            searchHelper(word, node.children[Character.toUpperCase(word.charAt(index))-'A'], index+1, list, exactly, exactlyList);
                        }
                    }


                }
            }

        }

    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Trie trie = new Trie(wordlist);
        int index = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : wordlist) {
            map.put(word, index++);
        }
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            String result = trie.search(query, map);
            res.add(result);
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        VowelSpellchecker v = new VowelSpellchecker();
        System.out.println(Arrays.toString(v.spellchecker(new String[] {"wg","uo","as","kv","ra","mw","gi","we","og","zu"}, new String[] {"AS","in","yc","kv","mw","ov","lc","os","wm","Mw"})));
    }
}
