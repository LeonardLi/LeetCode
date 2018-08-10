package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 867. Transpose Matrix
 *
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 *
 * Note:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        //int rank = Math.max(A.length, A[0].length);
        int [][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length;i++) {
            for (int j = 0; j< A[0].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

}
