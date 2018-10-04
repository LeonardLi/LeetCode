package com.xiaode.MediumSolutions;

import javax.swing.text.Position;

/**
 * Created by liyangde on Sep, 2018
 *
 * 55. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpGame {

    //TLE
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }


    //Optimize, still TLE
    enum Index {
        GOOD,
        BAD,
        UNKNOWN
    }
    Index[] memo;
    public boolean canJumpFromPosition2(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.max(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition2(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump2(int[] nums) {
        memo = new Index[nums.length];
        for (Index index : memo) {
            index = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition2(0, nums);
    }


    //Accept
    public boolean canJump3(int[] nums) {
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curMax < i) return false; //mean we are not able to reach position i
            curMax = Math.max(curMax, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        jumpGame.canJump3(new int[]{3,0,0,0,13,4,3,4});
    }


}
