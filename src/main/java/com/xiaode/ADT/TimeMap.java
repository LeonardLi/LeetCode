package com.xiaode.ADT;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by liyangde on Jan, 2019
 */
class TimeMap {

    HashMap<String, TreeMap<Integer, String>> store;
    /** Initialize your data structure here. */
    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(store.containsKey(key)) {
            store.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> node = new TreeMap<>();
            node.put(timestamp,value);
            store.put(key, node);
        }
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";
        TreeMap<Integer, String> node = store.get(key);
        for (Integer time : node.descendingKeySet()) {
            if (time <= timestamp) return node.get(time);
        }
        return "";
    }
}
