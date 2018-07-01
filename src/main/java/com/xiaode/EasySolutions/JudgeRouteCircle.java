package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 */
public class JudgeRouteCircle {
    /**
     * 657. Judge Route Circle
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,
     * which means it moves back to the original place.
     *
     * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves
     * are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
     */

    public boolean judgeCircle(String moves) {
        int [] count = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') count[0]++;

            if (moves.charAt(i) == 'R') count[0]--;

            if (moves.charAt(i) == 'U') count[1]++;

            if (moves.charAt(i) == 'D') count[1]--;
        }

        return count[0]==0 && count[1]==0 ? true : false;
    }

}
