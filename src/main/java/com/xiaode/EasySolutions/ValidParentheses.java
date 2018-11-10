package com.xiaode.EasySolutions;

import java.util.Stack;

/**
 * Created by xiaode on 4/4/17.
 */
public class ValidParentheses {
    /**
     * 20. Valid Parentheses
     * Gien a string containing just the characters (){}[],determine if the input string is valid
     * the brackets must close in the correct oeder, (),()[]{},are all valid but (] and ([)] are not
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s){
        Stack<Character> store = new Stack<>();
        if(s == null || s.length() % 2 != 0) return false;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if (store.isEmpty() || store.peek() != '(') return false;
                else store.pop();
                continue;
            }
            if(s.charAt(i) == ']'){
                if (store.isEmpty() || store.peek() != '[') return false;
                else store.pop();
                continue;
            }
            if(s.charAt(i) == '}'){
                if (store.isEmpty() || store.peek() != '{') return false;
                else store.pop();
                continue;
            }
            store.push(s.charAt(i));
        }
        return store.isEmpty();
    }

}
