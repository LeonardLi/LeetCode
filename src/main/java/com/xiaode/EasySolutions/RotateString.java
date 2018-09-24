package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 796. Rotate String
 *
 * We are given two strings, A and B.
 *
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 *
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 *
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * Note:
 *
 * A and B will have length at most 100.
 */
public class RotateString {

    // not right

    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) return false;
        int i = 0;
        String A1 = "";
        while(i < A.length()) {
            if (A.charAt(i) == B.charAt(0)) {
                A1 = A.substring(i) + A.substring(0,i);
                break;
            } else {
                i++;
            }
        }

        return B.equals(A1);
    }

    public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
    public static void main(String[] args) {
        RotateString rotateString = new RotateString();
        rotateString.rotateString("abcde", "cdeab");
    }
}
