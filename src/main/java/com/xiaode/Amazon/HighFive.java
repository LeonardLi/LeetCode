package com.xiaode.Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyangde on Jan, 2019
 */
public class HighFive {


    public static Map<Integer, Double> getHighFive(Result[] results) {
        Map<Integer, Double> map = new HashMap<>();
        Map<Integer, ArrayList<Integer>> pValue = new HashMap<>();
        for (Result res : results) {
            int id = res.id;
            ArrayList<Integer> curL = pValue.getOrDefault(id, new ArrayList<>());
            curL.add(res.value);
            pValue.put(id, curL);
        }
        for (Integer id : pValue.keySet()) {
            ArrayList<Integer> list = pValue.get(id);
            Collections.sort(list, Collections.reverseOrder());

            double value = 0;
            for (int k = 0; k < 5 && k < list.size(); k++) {
                value += list.get(k);
            }
            value = value / 5.0;
            map.put(id, value);
        }
        return map;
    }
}

class Result {
    int id;
    int value;

    public Result(int id, int value) {
        this.id = id;
        this.value = value;
    }
}