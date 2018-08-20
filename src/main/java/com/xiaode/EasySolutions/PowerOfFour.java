package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 342. Power of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        int i = num & (num - 1); //if power of 2
        if (i != 0) return false;
        int j = num & 0x55555555; // check odd index
        return j > 0;
    }
    public static void main(String[] args) {
        PowerOfFour pf = new PowerOfFour();
        pf.isPowerOfFour(-2147483647);
    }
}
