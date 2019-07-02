package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 *
 * 361. Bomb Enemy
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 *
 * Example:
 *
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3
 * Explanation: For the given grid,
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 * Placing a bomb at (1,1) kills 3 enemies.
 */
public class BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]== '0') {
                    res = Math.max(res, count(i, j, grid));
                }
            }
        }
        return res;
    }

    private int count(int row, int col, char[][] grid) {
        int count = 0;
        int i = row;
        int j = col;
        //right
        while(++i < grid.length){
            if(grid[i][col] == 'W') break;
            if(grid[i][col] == 'E') count++;
        }
        //left
        i = row;
        while(--i >= 0 ){
            if(grid[i][col] == 'W') break;
            if(grid[i][col] == 'E') count++;
        }

        while(++j < grid[0].length){
            if(grid[row][j] == 'W') break;
            if(grid[row][j] == 'E') count++;
        }
        j = col;
        while(--j >= 0){
            if(grid[row][j] == 'W') break;
            if(grid[row][j] == 'E') count++;
        }

        return count;
    }

}
