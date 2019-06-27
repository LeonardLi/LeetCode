package com.xiaode.Contest;

import java.util.Stack;

/**
 * Created by liyangde on May, 2019
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        String res = "";
        for(char c : S.toCharArray()) {
            if(stack.size() > 0) {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        while(stack.size() > 0) {
            res = stack.pop()+res;
        }
        return res;
    }
}
