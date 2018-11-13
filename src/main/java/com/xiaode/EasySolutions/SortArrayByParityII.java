package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liyangde on Nov, 2018
 *
 * 922. Sort Array By Parity II
 *
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 *
 * Note:
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for(int n : A) {
            if(n % 2 == 0) evens.add(n);
            else odds.add(n);
        }

        Collections.sort(odds);
        Collections.sort(evens);

        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++) {

            res[i] = i % 2 == 0 ? evens.get(i/2):odds.get(i/2);
        }

        return res;
    }
}