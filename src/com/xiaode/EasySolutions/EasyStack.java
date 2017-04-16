package com.xiaode.EasySolutions;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by xiaode on 3/24/17.
 */
public class EasyStack {
    int []elements;
    private int currentIndex = 0;
    /** Initialize your data structure here. */
    public EasyStack() {
        elements = new int[16];
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(currentIndex != elements.length-1){
            elements[++currentIndex] = x;
        }else{
            elements = resize();
            elements[++currentIndex] = x;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(currentIndex > 0){

            return elements[currentIndex--];
        }else {
             throw new EmptyStackException();
        }

    }

    /** Get the top element. */
    public int top() {
        return elements[currentIndex];
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return currentIndex == 0;
    }

    private int[] resize(){
        int [] newElements = new int[2* currentIndex];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        return newElements;
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */