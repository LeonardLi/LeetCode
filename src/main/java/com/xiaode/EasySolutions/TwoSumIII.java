package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liyangde on Nov, 2018
 *
 * 170. Two Sum III - Data structure design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example 1:
 *
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * Example 2:
 *
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */
public class TwoSumIII {
    /** Initialize your data structure here. */
    List<Integer> numbers;
    Set<Integer> sums;
    public TwoSumIII() {
        numbers = new ArrayList<>();
        sums = new HashSet<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {

        if (numbers.size() > 0){
            numbers.forEach(num -> sums.add(num+number));
        }
        numbers.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sums.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
