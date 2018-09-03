package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray
 *
 * scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 *
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {

        if(M.length == 1 && M[0].length == 1) return M;

        int [][] N = new int[M.length][M[0].length];

        if(M.length == 1){
            for(int k = 0; k < M[0].length; k++) {
                if(k == 0) {
                    N[0][k] = (int) Math.floor((M[0][k] + M[0][k + 1])/ 2);
                } else if (k == M[0].length - 1) {
                    N[0][k] = (int) Math.floor((M[0][k] + M[0][k - 1])/ 2);
                } else {
                    N[0][k] = (int) Math.floor((M[0][k - 1] + M[0][k] + M[0][k + 1])/ 3);
                }
            }
            return N;
        }
        if(M[0].length == 1) {
            for(int k = 0; k < M.length; k++) {
                if(k == 0) {
                    N[k][0] = (int) Math.floor((M[k][0] + M[k + 1][0])/ 2);
                } else if (k == M.length - 1) {
                    N[k][0] = (int) Math.floor((M[k][0] + M[k - 1][0])/ 2);
                } else {
                    N[k][0] = (int) Math.floor((M[k - 1][0] + M[k][0] + M[k + 1][0])/ 3);
                }
            }
            return N;
        }
        //corner
        N[0][0] = (int) Math.floor((M[0][0] + M[0][1] + M[1][0] + M[1][1]) / 4);
        N[0][M[0].length - 1] = (int) Math.floor((M[0][M[0].length - 1] + M[0][M[0].length - 2] + M[1][M[0].length - 1] + M[1][M[0].length - 2]) / 4);
        N[M.length - 1][0] = (int) Math.floor((M[M.length - 1][0] + M[M.length - 1][1] + M[M.length - 2][0] + M[M.length - 2][1]) / 4);
        N[M.length - 1][M[0].length - 1] = (int) Math.floor((M[M.length - 1][M[0].length - 1] + M[M.length - 2][M[0].length - 1] + M[M.length - 1][M[0].length - 2] + M[M.length - 2][M[0].length - 2]) / 4);


        for(int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i == 0 && j == 0 || i == 0 && j == M[0].length - 1 || i == M.length -1 && j == 0 || i == M.length - 1 && j == M[0].length - 1 ) continue;
                //edge
                if (i == 0) {
                    N[i][j] = (int) Math.floor((M[i][j] + M[i][j + 1] + M[i][j - 1] + M[i + 1][j] + M[i + 1][j + 1] + M[i + 1][j - 1]) / 6);
                } else if (i == M.length - 1) {
                    N[i][j] = (int) Math.floor((M[i][j] + M[i - 1][j] + M[i][j + 1] + M[i][j - 1] + M[i - 1][j + 1] + M[i - 1][j - 1]) / 6);
                } else if (j == 0) {
                    N[i][j] = (int) Math.floor((M[i][j] + M[i][j + 1] + M[i + 1][j] + M[i + 1][j + 1] + M[i - 1][j] + M[i - 1][j + 1]) / 6);
                } else if (j == M[0].length - 1) {
                    N[i][j] = (int) Math.floor((M[i][j] + M[i][j - 1] + M[i - 1][j] + M[i - 1][j - 1] + M[i + 1][j] + M[i + 1][j - 1]) / 6);
                } else {
                    //other
                    N[i][j] = (int) Math.floor((M[i][j] + M[i + 1][j] + M[i - 1][j] + M[i][j + 1] + M[i + 1][j + 1] + M[i - 1][j + 1] + M[i - 1][j - 1] + M[i + 1][j - 1] + M[i][j - 1] ) / 9);
                }
            }
        }


        return N;
    }
}
