package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 2/21/17.
 */
public class HamingDistance {
    /**
     * 461. Hamming Distance
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * 0 ≤ x, y < 2 31.
     */
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int result = 0;
        while(z!= 0){
            if ((z & 0x01 )== 0x01) result++;
            z= z>>1;
        }
        return result;
    }
}
