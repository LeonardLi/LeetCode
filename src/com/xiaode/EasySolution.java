package com.xiaode;

/**
 * Created by xiaode on 11/9/16.
 */
public class EasySolution {
    /**
     * 463. Island Perimeter
     * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
     * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
     * and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water
     * inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is
     * rectangular, width and height don't exceed 100. Determine the perimeter of the island.
     */
    public int islandPerimeter(int [][] grid){
        if(grid == null || grid.length==0 || grid[0].length==0) return 0;
        int result = 0;
        for(int i = 0; i< grid.length;i++){
            for (int j = 0; j<grid[0].length;j++){
                if (grid[i][j]==1){
                    result+=4;
                    if (i > 0 && grid[i-1][j] == 1) result-=2;
                    if (j > 0 && grid[i][j-1] == 1) result-=2;
                }
            }
        }
        return result;
    }

    /**
     * 453. Minimum Moves to Equal Array Elements
     * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements
     * equal, where a move is incrementing n - 1 elements by 1.
     */
    public int minMoves(int[] nums){
        if (nums.length == 0 ) return 0;
        int min = nums[0];
        for (int n: nums){
            min = Math.min(min,n);
        }
        int res = 0;
        for (int n:nums
             ) {
            res += n-min;

        }
        return res;
    }

    /**
     * 461. Hamming Distance
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * 0 ≤ x, y < 2 31.
     */
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int result = 0;
        while(z!= 0){
            if ((z & 0x01 )== 0x01) result++;
            z= z>>1;
        }
        return result;
    }
}
