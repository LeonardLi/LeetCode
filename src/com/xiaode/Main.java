package com.xiaode;

import com.xiaode.EasySolutions.*;
import com.xiaode.HardSolutions.MedianOfTwoSortedArrays;
import com.xiaode.MediumSolutions.CountingBits;
import com.xiaode.MediumSolutions.ContainerWithMostWater;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Main {
    private static final Logger myLogger = Logger.getLogger("com.xiaode");

    public static void main(String[] args) {
//	// write your code here
//        MedianOfTwoSortedArrays ma = new MedianOfTwoSortedArrays();
//        ma.findMedianSortedArray(new int[]{1,2},new int[]{3,4});
//        MyThread myThread =  new MyThread();
//        myThread.start();
//        try {
//            Thread.sleep(1000);
//            myThread.interrupt();
//            System.out.println(myThread.isInterrupted());
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

        Scanner in = new Scanner(System.in);
        String test = in.nextLine();
        String pattern = in.nextLine();
        System.out.println(filter(test,pattern));
    //100-trade-done
        //1*trade*done
    }

    static int filter(String test, String pattern) {
        boolean[] match = new boolean[test.length()+1];
        for(int i=0; i<match.length; i++){
            match[i] = false;
        }
        match[test.length()] = true;
        for(int i=pattern.length()-1; i>=0; i--){
            if(pattern.charAt(i)=='*'){
                for(int j=test.length()-1; j>=0; j--){
                    match[j] = match[j]||match[j+1]&&(pattern.charAt(i-1)=='?'||pattern.charAt(i-1)==test.charAt(j));
                }
                i--;
            }else {
                for(int j=0; j<test.length(); j++){
                    match[j] = match[j+1]&&(pattern.charAt(i)=='?'||pattern.charAt(i)==test.charAt(j));
                }
                match[test.length()] = false;
            }
        }
        if (match[0]) return 1;
        return 0;

    }

    class MyThread extends Thread {
        private int count = 5;

        @Override
        synchronized public void run() {
            super.run();
            for (int i = 0; i < 50000000; i++) System.out.println(i);

        }
    }

    /**
     * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
     *
     * @return
     */
    static long doneTime(int maxQps, String[] rtList, int requestNum, int threadNum) {
        //TODO
        long totaltime = 0;
        totaltime = (long) (requestNum / (maxQps * rtList.length)) * threadNum;
        return totaltime;
    }

}
//
//输入:
//        输入数据包含5行数字: 第一行是每台broker的极限QPS 第二行是broker rt列表,用逗号分割，几个rt表示几个broker 第三行是消息生产请求总数 第四行是最大并发线程数
//        输出:
//        按照最大吞吐量执行完所有请求，需要耗时多少毫秒
//        输入范例:
//        200
//        1,1,1,10,10
//        5000
//        10
//        输出范例:
//        5000
