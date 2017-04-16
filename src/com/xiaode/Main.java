package com.xiaode;

import com.xiaode.EasySolutions.*;
import com.xiaode.HardSolutions.MedianOfTwoSortedArrays;
import com.xiaode.MediumSolutions.CountingBits;
import com.xiaode.MediumSolutions.ContainerWithMostWater;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
private static final Logger myLogger = Logger.getLogger("com.xiaode");
        public static void main(String[] args)  {
            //myLogger.getGlobal().setLevel(Level.OFF);
//            myLogger.getGlobal().info("begin");
//            Scanner in = new Scanner(System.in);
//            int maxQps= Integer.valueOf(in.nextLine());
//            final String[] rtList = in.nextLine().split(",");
//            final int requestNum = Integer.valueOf(in.nextLine());
//            final int threadNum = Integer.valueOf(in.nextLine());
//            System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
            System.out.println(ValidParentheses.isValid("[])"));
            System.out.println("hhhhh");

        }
        /**
         * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
         * @return
         */
        static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
            //TODO
            long  totaltime = 0;
            totaltime = (long)(requestNum/(maxQps * rtList.length)) * threadNum;
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
