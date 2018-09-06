package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 118. Pascal's Triangle
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 */
public class PascalsTriangle {
    // sol 1
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<>();

        //corner case

        if (numRows == 0) return triangle;
        if (numRows == 1) {
            triangle.add(Arrays.asList(1));
            return triangle;
        }
        if (numRows == 2) {
            triangle.add(Arrays.asList(1));
            triangle.add(Arrays.asList(1,1));
            return triangle;
        }

        triangle.add(Arrays.asList(1));
        triangle.add(Arrays.asList(1,1));
        //trivial case
        for (int i = 3; i <= numRows; i++) {
            List<Integer> row = new LinkedList<>();
            List<Integer> lastRow = ((LinkedList<List<Integer>>) triangle).getLast();
            row.add(1);
            for (int j = 1; j <= i - 2; j++ ) {
                row.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }

        return triangle;

    }

    //sol 2
    public List<List<Integer>> generate2(int numRows) {
        return null;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        pascalsTriangle.generate(5);
    }
}
