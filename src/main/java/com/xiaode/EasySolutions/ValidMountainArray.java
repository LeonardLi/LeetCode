package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 */
public class ValidMountainArray  {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        int peak = 0;
        boolean found = false;

        for (int i  = 1; i < A.length; i++ ) {
            if (!found) {
                if (A[i] < A[i-1]) {
                    if(i == 1) return false;
                    peak = A[i-1];
                    found = true;
                } else {
                    peak = A[i];

                    if(i == A.length - 1) return false;
                }
            }else {

                if (A[i] >=  A[i-1]) return false;
            }
        }
        return found;
    }

    public static void main(String[] args){
        ValidMountainArray v = new ValidMountainArray();
        v.validMountainArray(new int[]{9,8,7,6,5,4,3,2,1});
    }
}
