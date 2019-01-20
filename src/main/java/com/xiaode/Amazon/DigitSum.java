package com.xiaode.Amazon;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by liyangde on Jan, 2019
 */
public class DigitSum {
    public int getDigitSumParity(int[] arr) {
        int min = getMin(arr);
        int result = getSum(min);
        if (result % 2 == 0) return 1;
        else {
            return 0;
        }
    }

    public int getMin(int[] arr) {
        if (arr == null || arr.length <=0) {
            throw new IllegalArgumentException();
        }
        int min = arr[0];
        for (int i = 1, len = arr.length; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            int temp = num % 10;
            num = num / 10;
            sum = sum + temp;
        }
        return sum;
    }

    public static void main(String[] args) {
//        DigitSum d = new DigitSum();
//        System.out.println(d.getDigitSumParity(new int[]{1918,1010,9090,8012}));
        Distinct d2 = new Distinct();
        System.out.println(d2.sumDistinct(6, new int[]{1,2,3,4,4,5}));
    }
}

class Distinct{
    int sumDistinct(int size, int[] inputArray) {
        Arrays.sort(inputArray);
        int sum = inputArray[0];
        int point = inputArray[0];
        for (int i = 1; i < size; i++) {
            if (point != inputArray[i])
            {
                sum+=inputArray[i];
                point = inputArray[i];
            }
        }

        return sum;
    }
}