package com.xiaode;

import com.xiaode.EasySolutions.MaxConsecutiveOnes;
import com.xiaode.EasySolutions.NextGreaterElementI;
import com.xiaode.EasySolutions.NumberComplement;
import com.xiaode.MediumSolutions.CountingBits;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CountingBits cb = new CountingBits();
        int num = 200000000;
        long start = 0L;
        long end=0L;
        long time1,time2;
        start = System.currentTimeMillis();
        cb.countBits(num);
        start = System.currentTimeMillis();
        time1 = end-start;
        start = System.currentTimeMillis();
        cb.countBits2(num);
        end = System.currentTimeMillis();
        time2 = end-start;

        System.out.println("cb1: "+time1+"ms");
        System.out.println("cb2: "+time2+"ms");
    }
}
