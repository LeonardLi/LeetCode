package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. My Calendar II
 * Implement a MyCallendarTwo class to store your events. A new can be added if adding the event will not cause a triple
 * booking.
 */
public class MyCalendarII {
    private List<int[]> books = new ArrayList<>();

    public MyCalendarII() {
    }

    public boolean book(int start, int end) {
        MyCalenderI overlaps = new MyCalenderI();
        for (int[] b : books )
            if (Math.max(b[0],start) < Math.min(b[1], end)) //overlap exist
                if (!overlaps.book(Math.max(b[0], start), Math.min(b[1], end))) return false;
        books.add(new int[]{start, end});
        return true;
    }
}
