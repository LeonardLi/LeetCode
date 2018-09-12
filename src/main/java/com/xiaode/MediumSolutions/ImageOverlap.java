package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 835. Image Overlap
 *
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 *
 * Example 1:
 *
 * Input: A = [[1,1,0],
 *             [0,1,0],
 *             [0,1,0]]
 *        B = [[0,0,0],
 *             [0,1,1],
 *             [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes:
 *
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
public class ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;


        for(int i = 0; i < A[0].length; i++){
            for (int j = 0; j < A.length; j++){
                int overlaped = 0;

                for (int k = 0; k < A[0].length - i; k++){
                    for (int l = 0; l < A.length - j; l++){
                        if (B[k+i][l+j]* A[k][l] == 1) overlaped++;
                    }
                }
                max = Math.max(max, overlaped);
                overlaped = 0;
                for (int k = 0; k < A[0].length - i; k++){
                    for (int l = 0; l < A.length - j; l++){
                        if (A[k+i][l+j]* B[k][l] == 1) overlaped++;
                    }
                }
                max = Math.max(max, overlaped);
            }
        }

        return max;
    }
    public int largestOverlap2(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i) if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i) if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
        for (int i : LA) for (int j : LB)
            count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }
}
