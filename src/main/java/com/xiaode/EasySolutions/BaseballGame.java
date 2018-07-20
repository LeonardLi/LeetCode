package com.xiaode.EasySolutions;

import java.util.LinkedList;

/**
 * Created by liyangde on Jul, 2018
 *
 * 682. Baseball Game
 *
 * You're now a baseball game point recorder.
 *
 * Given a list of strings, each string can be one of the 4 following types:
 *
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 *
 * You need to return the sum of the points you could get in all the rounds.
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        LinkedList<Integer> count = new LinkedList<>();

        int sum = 0;

        for (String str: ops) {
            if (str.equals("D")){
                count.add(count.getLast()*2);
                sum+=count.getLast();
            }
            else if (str.equals("+")) {
                count.add(count.getLast() + count.get(count.size() - 2));
                sum+=count.getLast();

            }
            else if (str.equals("C")) {
                int num = count.removeLast();
                sum-=num;
            }
            else {
                int num = Integer.parseInt(str);
                count.add(num);
                sum +=  num;
            }
        }

        return  sum;
    }
}
