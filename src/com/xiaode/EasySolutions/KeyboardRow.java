package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by xiaode on 2/21/17.
 */
public class KeyboardRow {
    /**
     * 500. Keyboard Row
     * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of
     * American keyboard like the image below.
     */

    // 3 ms
    String row1 = "QWERTYUIOPqwertyuiop";
    String row2 = "ASDFGHJKLasdfghjkl";
    String row3 = "ZXCVBNMzxcvbnm";
    public String[] findWords(String[] words){

        List<String> strs = new ArrayList<>();
        //String[] result ;

        int i = 0;
        for (String word:words) {
            if(isMatch(row1, word) || isMatch(row2, word) || isMatch(row3, word)) {
            strs.add(word);
            }
        }

        return strs.toArray(new String[0]);
    }

    /**
     * check if b is in a
     * @param a is the dic
     * @param b is the word to be ckecked
     * @return
     */
    boolean isMatch(String a, String b){
        for(int i = 0; i < b.length();i++){
            if (!a.contains(String.valueOf(b.charAt(i)))) return false;
        }
        return true;
    }


// 89 ms
//    public String[] findWords(String[] words) {
//        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
//
//    }

}
