package com.xiaode.HardSolutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liyangde on Dec, 2018
 *
 * 317. Shortest Distance from All Buildings
 *
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 *
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 *
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * Output: 7
 *
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 *              the point (1,2) is an ideal empty land to build a house, as the total
 *              travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class ShortestDistanceFromAllBuildings {

    int[][] distance;
    int[][] reach;
    int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        distance = new int[m][n];
        reach = new int[m][n];
        int buildingNum = 0;

        // using bfs to count the total distance
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    buildingNum++;
                    bfs(grid, i ,j);
                }
            }
        }

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private void bfs(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        boolean[][] visited = new boolean[m][n];
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir: dirs) {
                    int x1 = dir[0]+curr[0];
                    int y1 = dir[1]+curr[1];
                    if (x1 < 0|| x1 >=m || y1<0 || y1 >=n) continue;
                    if (grid[x1][y1] != 0 || visited[x1][y1]) continue;
                    //find next 0
                    distance[x1][y1] += level;
                    reach[x1][y1]++;
                    visited[x1][y1] = true;
                    q.offer(new int[]{x1, y1});
                }
            }
            level++;
        }
    }
}
