package com.xiaode.ADT;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by liyangde on Sep, 2018
 */
public class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>();
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (q.size() < k)
            q.offer(val);
        else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }

        return q.peek();
    }

}
