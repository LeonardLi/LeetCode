package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 *
 * 758. Bold Words in String
 *
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.
 *
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
 *
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 *
 * Note:
 *
 * words has length in range [0, 50].
 * words[i] has length in range [1, 10].
 * S has length in range [0, 500].
 * All characters in words[i] and S are lowercase letters.
 */
public class BoldWordsinString {

    public String boldWords(String[] words, String S) {
        if (words == null || words.length == 0) return "";

        boolean[] marked = new boolean[S.length()];
        for (String word : words) {
            markWords(S, word, marked);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (marked[i] && (i == 0 || !marked[i - 1])) {
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if (marked[i] && (i == S.length() - 1 || !marked[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

    void markWords(String S, String word, boolean[] marked) {
        for (int i = 0; i <= S.length() - word.length(); i++) {
            String substr = S.substring(i, i + word.length());
            if (substr.equals(word)) {
                for (int j = i; j < i + word.length(); j++) {
                    marked[j] = true;
                }
            }
        }
    }

}
