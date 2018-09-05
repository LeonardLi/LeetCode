package com.xiaode.EasySolutions;

import java.util.LinkedList;


/**
 * Created by liyangde on Sep, 2018
 *
 * 844. Backspace String Compare
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        LinkedList<Character> strS = new LinkedList<>();
        LinkedList<Character> strT = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                strS.poll();
                continue;
            }
            strS.push(S.charAt(i));
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                strT.poll();
                continue;
            }
            strT.push(T.charAt(i));
        }

        return strS.toString().equals(strT.toString());
    }
}
