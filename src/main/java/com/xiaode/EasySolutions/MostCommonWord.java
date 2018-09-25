package com.xiaode.EasySolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyangde on Sep, 2018
 *
 * 819. Most Common Word
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * Different words in paragraph are always separated by a space.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> count = new HashMap<>();
        paragraph += '.';
        String word = "";
        String punc = "!?',;.";
        for (String ban : banned) {
            count.put(ban, -1);
        }
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) != ' '){
                if (punc.contains(String.valueOf(paragraph.charAt(i)))) {
                    if (count.containsKey(word) && count.get(word) == -1) {
                        word = "";
                    } else if (!word.equals("")){
                        count.put(word, count.getOrDefault(word, 0) + 1);
                        word = "";
                    }
                    continue;
                } else
                    word = word + Character.toLowerCase(paragraph.charAt(i));
            } else if (!word.equals("")) {
                if (count.containsKey(word) && count.get(word) == -1) {
                    word = "";
                    continue;
                } else {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                    word = "";
                }
            } else{

            }
        }

        int max = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                word = entry.getKey();
            }
        }

        return paragraph.length() == 0 ? "" : word;
    }



    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        mostCommonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});

    }
}
