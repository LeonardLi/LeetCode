package com.xiaode.MediumSolutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyangde on Jul, 2018
 *
 * 752. Open the Lock
 *
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6',
 *
 * '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 *
 * Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock
 *
 * will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of
 *
 * turns required to open the lock, or -1 if it is impossible.
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        Set<String> temp;
        while(!begin.isEmpty() && !end.isEmpty()) {
            //exchange begin and end set
            if (begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();

            for(String s : begin) {
                if(end.contains(s)) return level;
                if(deads.contains(s)) continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!deads.contains(s1))
                        temp.add(s1);
                    if(!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level ++;
            begin = temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        OpenTheLock opl = new OpenTheLock();
        //["0201","0101","0102","1212","2002"]
        //"0202"
        String[] deads = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        opl.openLock(deads, target);

    }
}
