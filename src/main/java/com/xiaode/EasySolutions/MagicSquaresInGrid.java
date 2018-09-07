package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 840. Magic Squares In Grid
 *
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 *
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 *
 * Example 1:
 *
 * Input: [[4,3,8,4],
 *         [9,5,1,9],
 *         [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 *
 * while this one is not:
 * 384
 * 519
 * 762
 *
 * In total, there is only one magic square inside the given grid.
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */
public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {

        if (grid == null || grid.length < 3 || grid[0].length < 3) return 0;
        int count = 0;

        for (int i = 0; i <= grid.length - 3; i++){
            for (int j = 0; j <= grid.length - 3;j++) {
                if (checkIfMagic(grid, i, j)) count++;
            }
        }

        return count;

    }

    private boolean checkIfMagic(int[][] grid, int x, int y) {
        int [][] test = new int[3][3];
        for (int k = 0; k < 3; k++){
            for (int m = 0; m < 3; m++) {
                if (grid[x+k][y+m] >=10 || grid[x+k][y+m] < 1) return false;
                test[k][m] = grid[x+k][y+m];
            }
        }

        int sum = test[0][0] + test[0][1] + test[0][2];

        for (int i = 0; i < 3; i++ ){
            if (sum != test[i][0] + test[i][1] + test[i][2]) {
                return false;
            }
            if (sum != test[0][i] + test[1][i] + test[2][i]) {
                return false;
            }
        }
        if (test[0][0] + test[1][1] + test[2][2] != sum || test[0][2] + test[1][1] + test[2][0] != sum) return false;

        return true;
    }
    public static void main(String[] args) {
        MagicSquaresInGrid magicSquaresInGrid = new MagicSquaresInGrid();

        int[][] test = {{10,3,5},{1,6,11},{7,9,2}};
        magicSquaresInGrid.numMagicSquaresInside(test);

    }
}
