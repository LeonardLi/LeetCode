package com.xiaode;

/**
 * Created by liyangde on Jul, 2018
 */
public class Main3 {
    public static void main(String[] args) {
        Integer integer = new Integer(5);
        testMethod(integer);
        System.out.println("integer:"+integer);
    }

    public static void testMethod(Integer i) {
        Integer b = i;
        i = i + 1;
        System.out.println("i:"+i+"\n"+"b:"+b+"\n");

    }

}
