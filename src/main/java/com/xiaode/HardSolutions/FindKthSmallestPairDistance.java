package com.xiaode.HardSolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Dec, 2018
 *
 * 719. Find K-th Smallest Pair Distance
 *
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
 *
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Note:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        //Minimum absolute difference
        int low = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++) {
            low = Math.min(low, nums[i+1] - nums[i]);
        }

        //Maximum abdolute difference
        int high = nums[n-1] - nums[0];

        //Do binary search for k-th absolute difference

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    // return number of pairs with absolute difference less than or equal to mid.
    private int countPairs(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; i++) {
            res += upperBound(a, i, n-1, a[i]+mid) - i -1;
        }
        return res;
    }

    //return index of first index of element which is greater than key
    private int upperBound(int[] a, int low, int high, int key) {
        if(a[high] <= key) return high+1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (key >= a[mid]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
