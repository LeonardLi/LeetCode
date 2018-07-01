package com.xiaode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListParamTest {
    public static void resetList(List<Integer> dataList){
        dataList.subList(2, 4).set(0,40);
        dataList = new ArrayList<Integer>(dataList);
        dataList.add(50);
    }
    public static void setOne(List<Integer> dataList){
        dataList.set(3, 100);
    }

}