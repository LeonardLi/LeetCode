package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 */
public class FlippingImage {
    /**
     * 832. Flipping an Image
     *
     * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
     *
     * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
     *
     * horizontally results in [0, 1, 1].
     *
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example,
     *
     * inverting [0, 1, 1] results in [1, 0, 0].
     *
     * Notes:
     *
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     *
     * first flip then invert
     *
     */
    public int[][] flipAndInvertImage(int[][] A) {

        //length equals 1, invert
        if (A[0].length <= 1){
            for (int i = 0; i < A.length; i++){
                A[i][0] = A[i][0] ^ 1;
            }
        } else {
            //at least 2 number in the vector
            for (int i = 0; i < A.length; i++){

                //first flip
                for (int j = 0; j < A[i].length / 2; j++){
                    //based on the length odevity of the vector, seems no need

                    A[i][j] = A[i][j] ^ A[i][A[i].length - j - 1];
                    A[i][A[i].length - j - 1] = A[i][A[i].length - j - 1] ^ A[i][j];
                    A[i][j] = A[i][j] ^ A[i][A[i].length - j - 1];
                }

                //then invert
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j] ^ 1;
                }

            }
        }
        return A;

    }
}
