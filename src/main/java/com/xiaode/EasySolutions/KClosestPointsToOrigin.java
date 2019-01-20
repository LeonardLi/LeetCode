package com.xiaode.EasySolutions;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by liyangde on Jan, 2019
 *
 * 973. K Closest Points to Origin
 * User Accepted: 376
 * User Tried: 398
 * Total Accepted: 376
 * Total Submissions: 417
 * Difficulty: Easy
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Double> queue = new PriorityQueue<>();
        HashMap<Double, int[]> map = new HashMap<>();
        int[][] res = new int[K][];
        for (int[] p : points) {
            double d = p[0]*p[0] + p[1]*p[1];
            map.put(d, p);
            queue.offer(d);
        }

        int i = 0;
        while (K-- > 0 ) {
            res[i++]= map.get(queue.poll());
        }
        return res;

    }
}
