package com.xiaode.EasySolutions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by liyangde on Dec, 2018
 */
public class ArrayDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) A[i] = A[i]* -1;
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }
        Arrays.sort(A);
        int count = 0;
        for (int i=0; count < A.length/2; i++) {
            if(map.get(A[i]) <= 0) continue;
            if(map.get(A[i]*2) == null || map.get(A[i]*2) == 0) return false;
            else {
                map.put(A[i]*2, map.get(A[i]*2) - 1);
                map.put(A[i], map.get(A[i])-1);
                count++;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ArrayDoubledPairs a = new ArrayDoubledPairs();
        System.out.println(a.canReorderDoubled(new int[]{-8,-3,8,8,4,-6,-4,2}));
    }
}
