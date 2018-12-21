package com.xiaode.google;

import java.util.Arrays;

/**
 * Created by liyangde on Dec, 2018
 */
public class TreeAncestor {

    int[] solution(int d, int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int parent = i;
            for (int depth = 0; depth < d; depth++) {
                if (A[parent] == -1) {
                    res[i] = -1;
                    break;
                }
                parent = A[parent];
                res[i] = parent;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor();
        System.out.println(Arrays.toString(treeAncestor.solution(2, new int[]{-1, 0, 1, 2, 3})));
    }
}
