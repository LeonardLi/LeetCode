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
        Stack<Character> stack = new Stack<>();
        int index = 0;
        if (s.length() <=1 ) return false;
        stack.push(s.charAt(index));
        while (index < s.length()){
            index++;

            if(index >= s.length()) {
                if(stack.size() !=0 ){
                    return false;
                }else{
                    return true;
                }
            }

            char temp = 0;
            if(stack.size()!= 0){
                if (')' == s.charAt(index)) {
                    temp = stack.pop();
                    if (! ('(' == temp)){
                        return  false;
                    }
                    continue;
                }
                if (']' == s.charAt(index)){
                    temp = stack.pop();
                    if (! ('[' == temp)){
                        return  false;
                    }
                    continue;
                }
                if ('}' == s.charAt(index)){
                    temp = stack.pop();
                    if (!('{' == temp)){
                        return  false;
                    }
                    continue;
                }
            }
            stack.push(s.charAt(index));
        }
        return true;
    }

}
