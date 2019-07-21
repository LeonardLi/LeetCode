package com.xiaode.MediumSolutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by liyangde on Jul, 2019
 * 1102. Path With Maximum Minimum Value
 *
 *Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
 *
 * The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
 *
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 */
public class PathWithMaximumMinimumValue {

    public int maximumMinimumPath(int[][] A) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[2] - a[2]));
        int n = A.length;
        int m = A[0].length;
        int[][] vv = new int[n][m];
        for (int[] v : vv) {
            Arrays.fill(v, -1);
        }

        pq.add(new int[] {0, 0, A[0][0]});
        vv[0][0] = A[0][0];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || vv[nx][ny] != 1) {
                    continue;
                }
                vv[nx][ny] = Math.min(p[2], A[nx][ny]);
                if (nx == n-1 && ny == m-1) {
                    return vv[nx][ny];
                }
                pq.add(new int[] {nx, ny, vv[nx][ny]});
            }
        }
        return -1;

    }
}
