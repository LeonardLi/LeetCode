package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 443. String Compression
 *
 * Given an array of characters, compress it in-place.
 *
 * The length after compression must always be smaller than or equal to the original array.
 *
 * Every element of the array should be a character (not int) of length 1.
 *
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */
public class StringCompression {

    public int compress(char[] chars) {
        //String dic = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxzy";
        String compressed = "";
        int[] result = new int[200];
        for (char c : chars){
            result[c]++;
        }

        for(int i = 0; i < 200; i++) {
            if (result[i] != 0){
                if (result[i] == 1) {
                    compressed+=(char)i;
                }
                else{
                    compressed = compressed + (char)i + result[i];
                }
            }
        }

        for (int i = 0; i < compressed.length(); i++ ) {
            chars[i] = compressed.charAt(i);
        }

        return compressed.length();

    }

    public int compress2(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        char[] test = {'a','a','a','b','b','a','a'};

        StringCompression sc = new StringCompression();
        sc.compress(test);
    }
}
