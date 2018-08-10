package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 887. Projection Area of 3D Shapes
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 *
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 *
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
 *
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 *
 * Return the total area of all three projections.
 *
 * Note:
 *
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 50
 */
public class ProjectionArea3DShapes {

    public int projectionArea(int[][] grid) {
        int xy = 0;
        int xz = 0;
        int yz = 0;

        int max = 0;
        int max2 = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) xy++;
                if (grid[i][j] > max) max =grid[i][j];
            }

            xz += max;
            max = 0;
        }

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] > max2) max2 = grid[j][i];
            }
            yz += max2;
            max2 = 0;
        }



        return xy + xz + yz;
    }
}
