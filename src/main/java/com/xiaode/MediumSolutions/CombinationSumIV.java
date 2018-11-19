package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangde on Nov, 2018
 *
 * 377. Combination Sum IV
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 */
public class CombinationSumIV {

    // TLE
    int res;
    public int combinationSum4(int[] nums, int target) {
        res = 0;
        backtracking(new ArrayList<>(), nums, 0, 0, target);
        return res;
    }

    private void backtracking(List<Integer> list, int[] nums, int start, int tempSum, int target) {
        if (tempSum > target) return;
        else if (tempSum == target) {
            res++;
            return;
        } else {
            for (int i = 0; i < nums.length; i++){
                list.add(nums[i]);
                backtracking(list, nums, start+1, tempSum+nums[i], target);
                list.remove(list.size() - 1);
            }
        }
    }


    public int combinationSum42(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum42(nums, target - nums[i]);
            }
        }
        return res;
    }

    public int combinationSum4dp(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }
    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        System.out.println(combinationSumIV.combinationSum4dp(new int[]{1,2,3},32));
    }
}
