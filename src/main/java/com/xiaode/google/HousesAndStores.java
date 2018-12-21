package com.xiaode.google;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by liyangde on Dec, 2018
 */
public class HousesAndStores {

    int [] solution(int[] stores, int[] hosuse) {

        int[] res = new int[hosuse.length];

        // res[i] stands for the closest store to house[i]
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < hosuse.length; i++) {
            for (int j = 0 ; j < stores.length; j++ ) {
                int distance = Math.abs(hosuse[i] - stores[j]);
                if (minDistance > distance){
                    res[i] = stores[j];
                    minDistance = distance;
                }
            }
            minDistance = Integer.MAX_VALUE;

        }

        return res;
    }

    // sort + binary search
    int[] solution2(int[] stores, int[] houses){
        int[] res = new int[houses.length]; // res[i] stands for the closest store to house[i]
        Arrays.sort(stores);
        for (int i = 0; i < houses.length; i++) {
            //binary search
            int low = 0, high = stores.length - 1;
            int mid = 0;
            while (low + 1 < high) {
                 mid = low + (high - low) / 2;
                if (stores[mid] == houses[i]) {
                    res[i] = stores[mid];
                    break;
                } else if (stores[mid] < houses[i]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            if (stores[mid] != houses[i]){
                if(Math.abs(stores[low] - houses[i]) <= Math.abs(stores[high] - houses[i])) {
                    res[i] = stores[low];
                } else {
                    res[i] = stores[high];
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        HousesAndStores h = new HousesAndStores();
        System.out.println(Arrays.toString(h.solution2(new int[]{1,5,20,11,16}, new int[]{5,10,17})));
    }
}
