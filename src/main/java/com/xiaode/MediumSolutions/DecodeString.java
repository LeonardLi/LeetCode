package com.xiaode.MediumSolutions;

import java.util.ArrayDeque;

/**
 * Created by liyangde on Sep, 2018
 *
 * 394. Decode String
 *
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() < 4) return null;
        ArrayDeque<Character> words = new ArrayDeque<>();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String res = "";
        char[] string = s.toCharArray();

        for (int i = 0; i < string.length ; i++) {
            if (Character.isDigit(string[i])){
                if (i > 0 && Character.isDigit(string[i-1])) {
                    numbers.push(numbers.poll() * 10 + Character.getNumericValue(string[i]));
                } else {
                    numbers.push(Character.getNumericValue(string[i]));
                }
            }
            else {
                if (string[i] == ']'){
                    //poll
                    String temp = "",temp2 = "";
                    char c;
                    while(true) {
                        c = words.poll();
                        if (c == '[') break;
                        temp =c + temp;
                    }
                    int times = numbers.poll();
                    while (times-- > 0) temp2+=temp;
                    for (char c1 : temp2.toCharArray()) {
                        words.push(c1);
                    }

                } else {
                    words.push(string[i]);
                }
            }
        }
        for (char c : words) {
            res = c + res;
        }

        return res;
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        decodeString.decodeString("100[leetcode]");
    }
}
