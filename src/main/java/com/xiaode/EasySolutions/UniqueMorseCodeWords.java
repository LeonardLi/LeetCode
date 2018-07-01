package com.xiaode.EasySolutions;

import java.util.HashSet;

/**
 * Created by liyangde on Jul, 2018
 */
public class UniqueMorseCodeWords {
    /**
     * 804. Unique Morse Code Words
     * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
     * as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
     *
     * Note:
     *
     * The length of words will be at most 100.
     * Each words[i] will have length in range [1, 12].
     * words[i] will only consist of lowercase letters.
     */

    public int uniqueMorseRepresentations(String[] words) {
        String[] dic = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> mors = new HashSet<>(100);

        //corner case
        if (words.length == 0) return 0;
        if (words.length == 0) return 1;

        //trans
        for (String str: words){
            String mor = new String();// better use ""
            for (int i = 0; i < str.length() ; i++) {
                mor += dic[str.charAt(i) - 97];
            }
            mors.add(mor);
        }

        return mors.size();
    }
}
