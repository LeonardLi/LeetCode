package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liyangde on Feb, 2019
 *
 * 986. Interval List Intersections
 */
public class IntervalListIntersections {

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> res = new ArrayList<>();
        List<Interval> all = new ArrayList<>();
        for (Interval a : A) all.add(a);
        for (Interval b : B) all.add(b);

        Collections.sort(all, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start >= o2.start) return 1;
                else return -1;
            }
        });
        int pStart = all.get(0).start;
        int pEnd = all.get(0).end;
        for (Interval i : all){
            if (i.start <= pEnd) {
                res.add(new Interval(i.start, pEnd));
            }
            else {
                pEnd = i.end;
            }
        }

        return res.toArray(new Interval[0]);

    }
}
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}