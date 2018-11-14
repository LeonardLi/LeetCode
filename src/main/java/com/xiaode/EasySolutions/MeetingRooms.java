package com.xiaode.EasySolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Nov, 2018
 *
 * 252. Meeting Rooms
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 */
public class MeetingRooms {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (e1, e2) -> {return e1.start - e2.start;});
        for(int i = 0; i < intervals.length - 1; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                if (intervals[j].start < intervals[i].end) return false;
            }
        }
        return true;
    }
}
