package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Jun, 2019
 */
public class ConfusingNumber {

    public boolean confusingNumber(int N) {
        int digit;
        int L = 0;
        Set<Integer> set = new HashSet<>(Arrays.asList(2,3,4,5,7));
        Map<Integer,Integer> map = new HashMap<>();
        map.put(6,9);
        map.put(9,6);
        while(N > 0) {
            digit = N % 10;
            if (set.contains(digit)) return false;
            L+=digit;
            L*=10;
        }
        return L==N;
    }
}
