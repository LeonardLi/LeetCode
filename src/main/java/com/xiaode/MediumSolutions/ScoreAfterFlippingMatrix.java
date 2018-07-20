package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 861. Score After Flipping Matrix
 *
 * We have a two dimensional matrix A where each value is 0 or 1.
 *
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s,
 *
 * and all 1s to 0s.
 *
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the
 *
 * matrix is the sum of these numbers.
 *
 * Return the highest possible score.
 *
 * Note:
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] is 0 or 1.
 *
 * NO fucking idea, not understand the answer yet
 *
 * https://leetcode.com/problems/score-after-flipping-matrix/discuss/143722/C++JavaPython-Easy-and-Concise
 *
 */
public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] A) {
        int M = A.length, N = A[0].length, res = (1 << (N - 1)) * M;
        for (int j = 1; j < N; j++) {
            int cur = 0;
            for (int i = 0; i < M; i++) cur += A[i][j] == A[i][0] ? 1:0;
            res += Math.max(cur, M - cur) * (1 << (N - j - 1));
        }
        return res;

    }
}
