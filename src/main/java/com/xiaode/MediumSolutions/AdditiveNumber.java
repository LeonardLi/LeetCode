package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 306. Additive Number
 *
 * Additive number is a string whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent
 *
 * number in the sequence must be the sum of the preceding two.
 *
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 */
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        String first;
        String second;
        for (int i = 1; i < num.length(); i++) {
            first = num.substring(0, i);
            for (int j = i + 1; j < num.length(); j++) {
                String newfirst = first;
                second = num.substring(i, j);
                if (second.startsWith("0") && second.length() > 1 ||
                        (newfirst.startsWith("0") && newfirst.length() > 1)) {
                    break;
                }
                int k = j;
                while (true) {
                    String expectedNext = String.valueOf(Long.parseLong(newfirst) + Long.parseLong(second));
                    int idx = k + expectedNext.length();
                    if (idx > num.length()) {
                        break;
                    }
                    String actualNext = num.substring(k, idx);
                    if (actualNext.equals(expectedNext)) {
                        if (num.endsWith(expectedNext)) {
                            return true;
                        } else {
                            newfirst = second;
                            second = expectedNext;
                            k = k + expectedNext.length();
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return false;

    }
}
