package com.xiaode.MediumSolutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liyangde on Feb, 2019
 *
 * 253. Meeting Rooms II
 */
public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o->o.end));

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }

            heap.offer(interval);
        }


        return heap.size();
    }
}
