package com.xiaode.MediumSolutions;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by liyangde on Sep, 2018
 *
 * 621. Task Scheduler
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        char[] taskQueue = new char[26];
        int i = 0;//time intervals
        int done = 0;
        ArrayDeque<Character> waitingList = new ArrayDeque<>();
        while (true) {

            if (done == tasks.length - 1 && waitingList.size() == 0) break;

            if (waitingList.size() != 0) {
                char task = waitingList.poll();

            }
            if ((i - taskQueue[tasks[done] - 'A']) < n) {
                waitingList.add(tasks[done]);
                done++;
            } else {
                done++;
            }


            i++;
        }
        return i;
    }

    public int leastInterval2(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
