package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 *
 * sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Dynamic programming
 *
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        // corner case
        if (grid.length == 0) return 0;
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
        int minPath = 0;

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (i == 0 && j == 0)
                {
                    continue;
                }

                int leftVal = (j-1) < 0 ? Integer.MAX_VALUE : grid[i][j-1];
                int topVal = (i-1) < 0 ? Integer.MAX_VALUE : grid[i-1][j];
                minPath += Math.min(leftVal,topVal);
            }
        }

        return minPath;
    }

    public int minPathSum2(int[][] grid) {

        int[] minPath = new int[grid[0].length];
        minPath[0] = grid[0][0];
        for(int i = 1; i < grid[0].length; ++i) {
            minPath[i] = minPath[i - 1] + grid[0][i];
        }

        for(int i = 1; i < grid.length; ++i) {
            minPath[0] += grid[i][0];
            for(int j = 1; j < grid[0].length; ++j) {
                minPath[j] = Math.min(minPath[j - 1], minPath[j]) + grid[i][j];
            }
        }

        return minPath[grid[0].length - 1];
    }

    //DFS TLE
    int[][] dirs = new int[][] {{0,1},{1,0}};
    int min = Integer.MAX_VALUE;
    public int minPathSum3(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        dfs(grid, 0, 0, 0, m, n);
        return min;
    }

    private void dfs(int[][] grid, int x, int y, int temp, int c, int r) {
        if(x >= c || y >= r) return;
        if(x == c-1 && y == r-1) {
            min = Math.min(temp+grid[x][y], min);
            return;
        }

        for(int[] dir : dirs) {
            dfs(grid, x+dir[0], y+dir[1], temp+grid[x][y], c ,r);
        }
        return;
    }
}
