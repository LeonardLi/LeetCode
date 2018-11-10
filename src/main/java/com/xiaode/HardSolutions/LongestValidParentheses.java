package com.xiaode.HardSolutions;

import java.util.Stack;

/**
 * Created by liyangde on Oct, 2018
 *
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> store = new Stack<>();

        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                store.push(i);
            }
            else {
                //')'
                if (!store.isEmpty()){
                    if(s.charAt(store.peek()) == '(') store.pop();
                    else store.push(i);
                } else {
                    store.push(i);
                }
            }
        }
        if(store.isEmpty()) res = n;
        else {
            int a = n, b = 0;
            while(!store.isEmpty()) {
                b = store.peek();
                store.pop();
                res = Math.max(res, a-b-1);
                a = b;
            }
            res = Math.max(res, a);
        }

        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        longestValidParentheses.longestValidParentheses(")()())");

    }
}
