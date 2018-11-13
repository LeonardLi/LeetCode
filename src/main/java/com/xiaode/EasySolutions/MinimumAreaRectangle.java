package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Nov, 2018
 * 939. Minimum Area Rectangle
 *
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 * Example 2:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 *
 *
 * Note:
 *
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 */
public class MinimumAreaRectangle {

    public int minAreaRect(int[][] points) {
        Set<Integer> s = new HashSet<>();
        for (int[] p : points) {
            s.add(p[0] * 40001 + p[1]);
        }
        int min = Integer.MAX_VALUE;
        int l = points.length;
        for (int i = 0; i < l; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < l; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                int need1 = p1[0] * 40001 + p2[1];
                int need2 = p2[0] * 40001 + p1[1];
                if (s.contains(need1) && s.contains(need2)) {
                    min = Math.min(Math.abs(p1[0]-p2[0]) * Math.abs(p1[1]-p2[1]), min);
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
