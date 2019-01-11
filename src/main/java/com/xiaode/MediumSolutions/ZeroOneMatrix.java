package com.xiaode.MediumSolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Jan, 2019
 */
public class ZeroOneMatrix {

    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length==0) return matrix;
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                if(matrix[i][j]==1 &&!hasNeiberZero(i, j,matrix))
                    matrix[i][j] = Integer.MAX_VALUE;

        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix[0].length; j++)
                if(matrix[i][j]==1)
                    dfs(matrix, i, j, -1);

        return matrix;
    }
    private void dfs(int[][] matrix, int x, int y, int val){
        if(x<0||y<0||y>=matrix[0].length||x>=matrix.length||matrix[x][y]<=val)
            return;
        if(val>0) matrix[x][y] = val;
        for(int[] dir: dirs){
            int x1=x+dir[0];
            int y1=y+dir[1];
            dfs(matrix,x1,y1,matrix[x][y]+1);
        }
    }
    private boolean hasNeiberZero(int x, int y, int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        for (int[] dir:dirs){
            int x1=x+dir[0];
            int y1=y+dir[1];
            if (x1>=0 && x1<m && y1>=0 && y1<n && matrix[x1][y1]==0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ZeroOneMatrix z = new ZeroOneMatrix();
        System.out.println(Arrays.toString(z.updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}})));
    }
}
