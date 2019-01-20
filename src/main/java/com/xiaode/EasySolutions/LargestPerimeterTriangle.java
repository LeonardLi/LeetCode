package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangde on Jan, 2019
 *
 * 976. Largest Perimeter Triangle
 *
 * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 *
 * If it is impossible to form any triangle of non-zero area, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [2,1,2]
 * Output: 5
 * Example 2:
 *
 * Input: [1,2,1]
 * Output: 0
 * Example 3:
 *
 * Input: [3,2,3,4]
 * Output: 10
 * Example 4:
 *
 * Input: [3,6,2,3]
 * Output: 8
 *
 *
 * Note:
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */
public class LargestPerimeterTriangle {

    int res;
    boolean isFound = false;
    public int largestPerimeter(int[] A) {
        res = 0;
        Arrays.sort(A);
        helper(A, A.length-1, new ArrayList<>());
        return res;
    }

    void helper(int[] A, int index, List<Integer> edges) {
        if (isFound) return;
        if (edges.size() == 3) {
            if (isTriangle(edges.get(0), edges.get(1), edges.get(2))) {
                res = edges.get(0) + edges.get(1) + edges.get(2);
                isFound = true;
            }
            return;
        } else {
            for (int i = index; i >=0 ; i--) {
                edges.add(A[i]);
                helper(A, i-1, edges);
                edges.remove(edges.size() - 1);
            }
        }
    }

    boolean isTriangle(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) return false;
        return true;
    }

    public static void main(String[] args){
        LargestPerimeterTriangle l = new LargestPerimeterTriangle();
        l.largestPerimeter(new int[] {1,2,1});
    }
}
