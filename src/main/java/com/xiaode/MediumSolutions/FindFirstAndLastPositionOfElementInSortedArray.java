package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        if (nums.length == 1) return target == nums[0] ? new int[]{0,0} : new int[]{-1,-1};
        int lo = 0, hi = nums.length - 1;
        int index = -1;
        int[] res = new int[2];
        while (lo < hi) {
            if (nums[lo] == target){
                index = lo;
                break;
            }
            if (nums[hi] == target){
                index = hi;
                break;
            }

            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        if (index == -1)  return new int[]{-1,-1};

        res[0] = index;
        res[1] = index;
        lo = index;
        hi = index;
        while(lo > 0 && nums[lo--] == target){
            res[0] = lo;
        }
        while(hi < nums.length - 1 && nums[hi++] == target) {
            res[1] = hi;
        }

        return res;
    }
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        f.searchRange(new int[]{2,2}, 2);

    }
}
