package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Jun, 2019
 *
 * 1086. High Five
 *
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 *
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 */
public class HighFive {

    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] item : items) {
            PriorityQueue<Integer> queue = map.getOrDefault(item[0], new PriorityQueue<>((o1, o2) -> o2-o1));
            queue.add(item[1]);
            map.put(item[0], queue);
        }
        int res[][] = new int[map.size()][2];
        int i =0;
        for (Map.Entry entry : map.entrySet()) {
            res[i][0] = (Integer)entry.getKey();
            PriorityQueue<Integer> queue = (PriorityQueue<Integer>) entry.getValue();
            int N = 5;
            int Sum = 0;
            while(N-- >0) {
                Sum+=queue.poll();
            }
            res[i++][1] = Sum/5;
        }
        return res;
    }
}
