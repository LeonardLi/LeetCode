package com.xiaode.EasySolutions;

import java.util.Stack;

/**
 * Created by liyangde on Aug, 2018
 *
 * 232. Implement Queue using Stacks
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
public class ImplementQueueUsingStacks {
}

class MyQueue {

    Stack<Integer> values;
    /** Initialize your data structure here. */
    public MyQueue() {
        values = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        values.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return values.remove(0);
    }

    /** Get the front element. */
    public int peek() {
        return values.elementAt(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return values.size() == 0;
    }

}