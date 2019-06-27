package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on May, 2019
 */
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int [] numbers = new int[10000];
        Set<Integer> set = new HashSet<>();
        for (int b : barcodes) {
            numbers[b]++;
            set.add(b);
        }
        List<Integer> list = new ArrayList<>(set);
        int [] res = new int[barcodes.length];
        int n = 0;

        while( n < barcodes.length) {
            int a = findMax(list, numbers);
            numbers[a]--;
            res[n] = a;
            n++;
        }
        return res;
    }
    private int findMax(List<Integer> list, int[] numbers) {
        int max = 0;
        int temp = 0;
        for(int i : list) {
            if (numbers[i] > max) {
                temp = i;
                max = numbers[i];
            }
        }

        return temp;
    }




    public static void main(String[] args) {
        DistantBarcodes d = new DistantBarcodes();
        System.out.println();d.rearrangeBarcodes(new int[] {1,1,1,1,2,2,3,3});
    }

}
