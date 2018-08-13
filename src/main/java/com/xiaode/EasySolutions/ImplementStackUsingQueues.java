package com.xiaode.EasySolutions;

import java.util.ArrayDeque;

/**
 * Created by liyangde on Aug, 2018
 *
 * 225. Implement Stack using Queues
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 */
public class ImplementStackUsingQueues {
}

class MyStack {
    ArrayDeque<Integer> values;
    final int INIT_SIZE = 16;
    /** Initialize your data structure here. */
    public MyStack() {
        values = new ArrayDeque<>(16);
    }

    /** Push element x onto stack. */
    public void push(int x) {
        values.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return values.pop();
    }

    /** Get the top element. */
    public int top() {
        return values.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return values.size() == 0;
    }
}