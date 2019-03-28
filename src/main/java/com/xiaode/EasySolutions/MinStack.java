package com.xiaode.EasySolutions;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by liyangde on Jul, 2018
 */
public class MinStack {
    /**
     * 155. Min Stack
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     */
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || getMin() >= x) minStack.push(x);
        dataStack.push(x);
    }

    public void pop() {
        Integer num = dataStack.pop();
        if (num.equals(minStack.peek())) minStack.pop();//这里不能用 == 运算符因为是Integer类型，切记莫忘
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        obj.getMin();
        obj.pop();
        obj.getMin();
        obj.pop();
        obj.getMin();
    }
}
