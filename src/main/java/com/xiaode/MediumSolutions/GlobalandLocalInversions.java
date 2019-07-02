package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 *
 * 775. Global and Local Inversions
 */
public class GlobalandLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int cmax =  0;
        for (int i = 0; i < A.length - 2; ++i) {
            cmax = Math.max(cmax, A[i]);
            if (cmax > A[i+2]) return false;
        }
        return true;
    }
}
