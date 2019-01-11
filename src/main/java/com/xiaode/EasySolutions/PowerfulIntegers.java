package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by liyangde on Jan, 2019
 */
public class PowerfulIntegers {

    //TreeMap<Integer, int[]> map = new TreeMap<>();
    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        HashSet<Integer> set = new HashSet<>();
        if (bound < 2) return new ArrayList<>(set);

        for (int i = 0; ;i++) {
            for (int j = 0; ; j++) {
                int res = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                if (res > bound) {
                    break;
                } else {
                    set.add(res);
                    if (y == 1) break;
                    //map.put(res,new int[]{i, j});
                }
            }
            if (x !=1 && (int)Math.pow(x, i) - 1 > bound) break;
            if (x == 1) break;
        }

        return new ArrayList(set);

    }
}
