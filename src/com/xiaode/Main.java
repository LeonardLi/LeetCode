package com.xiaode;

import com.xiaode.EasySolutions.NextGreaterElementI;
import com.xiaode.EasySolutions.NumberComplement;

public class Main {

    public static void main(String[] args) {
	// write your code here
        NextGreaterElementI nge = new NextGreaterElementI();
        int[] a = {4,1,2};
        int[] b = {1,3,4,2};

        System.out.println( nge.nextGreaterElement(a,b));
    }
}
