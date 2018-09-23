package com.xiaode.MediumSolutions;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by liyangde on Sep, 2018
 *
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums, Collections.reverseOrder());
        int temp = newNums[0];
        int count = 1;
        for (int i = 1; i < newNums.length; i++ ){
            if (temp >= newNums[i]){
                count++;
                temp = newNums[i];
                if (count == k) break;
            }
        }
        return temp;
    }
}
