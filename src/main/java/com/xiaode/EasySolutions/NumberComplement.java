package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 2/21/17.
 */
public class NumberComplement {
    /**
     * 476. Number Complement
     *Given a positive integer, output its complement number. The complement strategy is to flip the
     *  bits of its binary representation.
     */
    public int findComplement(int num){
        //return ~num & ((Integer.highestOneBit(num) << 1 ) - 1);//in one line
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }
}
