package com.xiaode.MediumSolutions;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by liyangde on Sep, 2018
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 */
public class FindTheDuplicateNumber {

    //very fast
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int quick = nums[nums[0]];

            while (slow != quick) {
                slow = nums[slow];
                quick = nums[nums[quick]];
            }

            quick = 0;
            while (quick != slow) {
                quick = nums[quick];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }


    public int findDuplicate2(int[] nums) {
        BitSet bitSet = new BitSet(32);
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (bitSet.get(nums[i])){
                res = nums[i];
                break;
            }
            bitSet.set(nums[i]);
        }
        return res;
    }
}
