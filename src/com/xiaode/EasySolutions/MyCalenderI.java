package com.xiaode.EasySolutions;


import java.util.*;

/**
 * 729. My Calender I
 * Implement a Mycalender class to store your events. A new event can be added if adding the event will not cause a double booking.
 * Your class will have method, book(int start, int end). Formally, this represents a booking on the half open interval
 * [start, end], the range of real numbers x such that start <= x < end.
 * A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both
 * events.) For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully
 * without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 * Your class will be called like this: Mycalendar cal = new MyCalendar(); Mycalendar.book(start, end)
 */
/*logical right, exceed time limit
    Using Treemap's floorkey and ceilingkey is brilliant way to solve the problem.
 */
public class MyCalenderI {
    TreeMap<Integer, Integer> calendar;
    LinkedList<Event> events = new LinkedList<>();
    class Event{
        int start;
        int end;
        public Event(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public MyCalenderI() {
        calendar = new TreeMap<>();
    }
    public boolean book2(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) return false;
        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;

        calendar.put(start, end);
        return true;
    }
    public boolean book(int start, int end) {
        Event event = new Event(start,end);
        return add(event);
    }
    private boolean add(Event event) {
        Event cur;
        //corner case
        if (events.size() == 0) {
            events.add(event);
            return true;
        }

        cur = events.getFirst();
        if (cur.start >= event.end) {
            events.addFirst(event);
            return true;
        }
        cur = events.getLast();
        if (cur.end <= event.start) {
            events.addLast(event);
            return true;
        }


        //trivial case
        for (int i = 0; i < events.size(); i++) {
            cur = events.get(i);
            Event pre;
            //Event next = events.get(i+1);
            if (event.end <= cur.start && i > 0) {
                pre = events.get(i-1);
                if (pre != null && pre.end <= event.start) {
                    events.add(i,event);
                    return true;
                } else {
                    return false;
                }
            } else {
                if (event.start > cur.end) continue;
                if (event.start < cur.end) return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        MyCalenderI obj = new MyCalenderI();
        obj.book(10,20);
        obj.book(15,25);
        obj.book(20,30);
    }
}

