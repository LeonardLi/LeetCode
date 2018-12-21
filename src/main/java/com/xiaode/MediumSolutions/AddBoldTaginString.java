package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Dec, 2018
 *
 * 616. Add Bold Tag in String
 *
 */
public class AddBoldTaginString {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        AddBoldTaginString addBoldTaginString = new AddBoldTaginString();
        addBoldTaginString.addBoldTag("abcxyz123", new String[]{"abc","123"});
    }
}
