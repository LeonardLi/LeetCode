package com.xiaode.Amazon;

import java.util.*;

/**
 * Created by liyangde on Jan, 2019
 */
public class MinimizeCost {

    List<Connections> minimumCostConnection(int num, List<Connections> connection) {
        if (connection == null || num == 0) {
            return new ArrayList<>();
        }

        ArrayList<Connections> result = new ArrayList<>();
        Collections.sort(connection, Comparator.comparingInt(c->c.cost));
        UnionFind uf = new UnionFind();
        for (Connections c : connection) {
            if (uf.union(c)) {
                result.add(c);
            }
        }

        Collections.sort(result, (o1, o2) -> {
            if (o1.first.equals(o2.first)) {
                return o1.second.compareTo(o2.second);
            }
            return o1.first.compareTo(o2.first);
        });
        return result;
    }

}

class Connections {
    public String first;
    public String second;
    public int cost;
    public Connections() {}

    public Connections(String t1, String t2, int c) {
        this.first = t1;
        this.second = t2;
        this.cost = c;
    }
}

class UnionFind {
    private Map<String, Integer> map;
    private int setNum;

    public UnionFind() {
        map = new HashMap<>();
        setNum = 0;
    }

    public boolean union(Connections conn) {

        if (!map.containsKey(conn.first) && !map.containsKey(conn.second)) {
            map.put(conn.first, setNum);
            map.put(conn.second, setNum);
            setNum++;
            return true;
        }

        if (map.containsKey(conn.first) && !map.containsKey(conn.second)) {
            map.put(conn.second, map.get(conn.first));
            return true;
        }
        if (!map.containsKey(conn.first) && map.containsKey(conn.second)) {
            map.put(conn.first, map.get(conn.second));
            return true;
        }

        // union sets
        if (map.containsKey(conn.first) && map.containsKey(conn.second)) {
            int num1 = map.get(conn.first);
            int num2 = map.get(conn.second);
            if (num1 == num2) { // avoid ring
                return false;
            }
            for (String city : map.keySet()) {
                if (map.get(city) == num1) {
                    map.put(city, num2);
                }
            }
            return true;
        }
        return false;
    }
}
