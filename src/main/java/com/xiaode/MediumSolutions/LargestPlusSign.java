package com.xiaode.MediumSolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Jul, 2019
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign2(int N, int[][] mines) {
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }

        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));  // left direction
                System.out.println("i,j: "+i+" "+j+" "+grid[i][j]);
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));  // right direction
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));  // up direction
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));  // down direction
            }
        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;

    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int res = 0;
        int[][] grid = new int[N][N];

        for(int[] mine : mines) {
            grid[mine[0]][mine[1]] = 1;
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] == 0) {
                    res = Math.max(res, count(i, j, grid, N));
                }
            }
        }
        return res;
    }

    private int count(int row, int col, int[][]grid, int N) {
        if(row == N-1 || row == 0 || col == N-1 || col == 0) return 1;
        //left
        int i = row;
        int j = col;
        int order_l=1, order_r=1, order_up=1, order_down=1;
        while(++i < N) {
            if(grid[i][col] == 1) break;
            else order_l++;
        }
        i = row;
        while(--i >= 0) {
            if(grid[i][col] == 1) break;
            else order_r++;
        }

        while(++j < N) {
            if (grid[row][j] == 1) break;
            else order_down++;
        }

        j = col;

        while(--j >= 0) {
            if (grid[row][j] == 1) break;
            else order_up++;
        }
        return Math.min(Math.min(order_l, order_r), Math.min(order_up, order_down));
    }

}
