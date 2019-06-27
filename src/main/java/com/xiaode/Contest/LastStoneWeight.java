package com.xiaode.Contest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liyangde on May, 2019
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if(a - b > 0) {
                queue.add(a - b);
            }
        }
        return queue.size() == 0 ? 0:queue.poll();
    }
}
