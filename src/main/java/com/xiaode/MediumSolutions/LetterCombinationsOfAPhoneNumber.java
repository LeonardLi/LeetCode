package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return Collections.emptyList();
        char[][] dic = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        char[] digitsArray = digits.toCharArray();
        List<String> res = new ArrayList<>();
        backtrack(res, dic, digitsArray, "",0);
        return res;
    }

    private void backtrack(List<String> list, char[][] dic, char[] digits, String temp, int start) {
        if (temp.length() == digits.length) list.add(temp);
        for (int i = start; i < digits.length; i++) {
            for (int j = 0; j < dic[Character.getNumericValue(digits[i]) - 2].length; j++) {
                backtrack(list, dic, digits, temp + dic[Character.getNumericValue(digits[i]) - 2][j],i+1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        letterCombinationsOfAPhoneNumber.letterCombinations("23");
    }
}
