package com.xiaode.HardSolutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyangde on Dec, 2018
 *
 * 489. Robot Room Cleaner
 *
 * Given a robot cleaner in a room modeled as a grid.
 *
 * Each cell in the grid can be empty or blocked.
 *
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean move();
 *
 *   // Robot will stay on the same cell after calling turnLeft/turnRight.
 *   // Each turn will be 90 degrees.
 *   void turnLeft();
 *   void turnRight();
 *
 *   // Clean the current cell.
 *   void clean();
 * }
 * Example:
 *
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 *
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 */
public class RobotRoomCleaner {

    public void cleanRoom(Robot robot) {
        Set<String> set = new HashSet<>();
        backtrack(robot, set, 0, 0, 0);
    }

    private void backtrack(Robot robot, Set<String> set, int i, int j, int cur_dir) {
        String tmp = i + "->" + j;
        if (set.contains(tmp)) return;
        robot.clean();
        set.add(tmp);

        for (int n = 0; n < 4; n++) {
            if (robot.move()) {
                int x = i, y = j;
                switch (cur_dir) {
                    case 0:
                        // go up, reduce i
                        x = i-1;
                        break;
                    case 90:
                        // go right
                        y = j+1;
                        break;
                    case 180:
                        // go down
                        x = i+1;
                        break;
                    case 270:
                        // go left
                        y = j-1;
                        break;
                    default:
                        break;
                }
                backtrack(robot, set, x, y, cur_dir);
                //go back to the starting position
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            // turn to next direction
            robot.turnRight();
            cur_dir += 90;
            cur_dir %= 360;
        }
    }
}
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();
}
