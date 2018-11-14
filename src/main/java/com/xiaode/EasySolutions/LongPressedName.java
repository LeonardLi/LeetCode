package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 *
 * 925. Long Pressed Name
 *
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 *
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 *
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 *
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 *
 * Note:
 *
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int p1 = 0;
        int p2 = 0;
        if (name.charAt(p1) != typed.charAt(p2)) return false;
        while (p1 < name.length() && p2 < typed.length()) {
            if (name.charAt(p1) == typed.charAt(p2)) {
                p1++;
                p2++;
            } else if (typed.charAt(p2) == typed.charAt(p2-1)) {
                p2++;
            } else {
                return false;
            }
        }

        if (p1 != name.length()) return false;
        else if (p2 < typed.length()) {
            while(p2 < typed.length()){
                if (typed.charAt(p2) != typed.charAt(p2-1)) return false;
                p2++;
            }
            return true;
        }
        else return true;

    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        longPressedName.isLongPressedName("vtkgn","vttkgnn");


    }
}
