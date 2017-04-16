package com.xiaode;

import com.xiaode.EasySolutions.*;
import com.xiaode.HardSolutions.MedianOfTwoSortedArrays;
import com.xiaode.MediumSolutions.CountingBits;
import com.xiaode.MediumSolutions.ContainerWithMostWater;

public class Main {

    public static void main(String[] args) {
//	// write your code here
//        MedianOfTwoSortedArrays ma = new MedianOfTwoSortedArrays();
//        ma.findMedianSortedArray(new int[]{1,2},new int[]{3,4});
        MyThread myThread =  new MyThread();
        myThread.start();
        try {
            Thread.sleep(1000);
            myThread.interrupt();
            System.out.println(myThread.isInterrupted());
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}

class MyThread extends Thread{
    private int count = 5;
    @Override
    synchronized public void run(){
        super.run();
        for (int i=0;i< 50000000;i++) System.out.println(i);
    }
}
