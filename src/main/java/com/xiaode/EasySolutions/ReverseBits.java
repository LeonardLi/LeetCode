package com.xiaode.EasySolutions;

import java.util.HashMap;

/**
 * Created by liyangde on Jul, 2018
 *
 * 190. Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    HashMap<Integer,Integer> reverseMap = new HashMap<>();
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (reverseMap.containsKey(n)) return reverseMap.get(n);

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        reverseMap.put(n,result);
        return result;
    }

    public static void main(String[] args){
        int test = 43261596; //(00000010100101000001111010011100);
        ReverseBits rb = new ReverseBits();
        rb.reverseBits(test);
    }
}
