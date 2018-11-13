package com.xiaode.EasySolutions;

import java.util.ArrayDeque;
import java.util.OptionalDouble;
import java.util.Queue;


/**
 * Created by liyangde on Nov, 2018
 *
 * 346. Moving Average from Data Stream
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage{
    private Queue<Integer> numbers;
    private int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        numbers = new ArrayDeque<>();
        this.size = size;
    }

    public double next(int val) {
        if (numbers.size() >= this.size) {
            numbers.poll();
        }
        numbers.add(val);

        OptionalDouble average = numbers.stream().mapToDouble(a -> a).average();
        return average.getAsDouble();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
