package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 693. Binary Number with Alternating Bits
 *
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
 */
public class BinaryNumberAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        boolean flag = true;
        int bit = 0;

        while(n > 0) {
            bit = n & 1;
            n = n >>> 1;
            if (bit == (n & 1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
