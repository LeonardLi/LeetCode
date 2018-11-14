package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Nov, 2018
 *
 * 716. Max Stack
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */
public class MaxStack {

    LinkedList<KV> list;
    Queue<KV> queue;


    /** initialize your data structure here. */
    public MaxStack() {
        list = new LinkedList<>();
        queue = new PriorityQueue<>(new Comparator<KV>() {
            @Override
            public int compare(KV o1, KV o2) {
                if (o2.key - o1.key > 0) return 1;
                else return -1;
            }
        });
    }

    public void push(int x) {
        KV e = new KV(x, list.size());
        list.add(e);
        queue.add(e);
    }

    public int pop() {
        KV e = list.remove(list.size() - 1);
        queue.remove(e);
        return  e.key;
    }

    public int top() {
        return list.get(list.size() - 1).key;
    }

    public int peekMax() {
        return queue.peek().key;
    }

    public int popMax() {
        KV e = queue.poll();
        list.remove(e);
        return e.key;

    }

    class KV{
        int key;
        int value;
        KV(int key, int value) {this.key = key; this.value = value;}
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        System.out.println(maxStack.top());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.top());
        System.out.println(maxStack.peekMax());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.pop());
    }
}
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */