package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by liyangde on Nov, 2018
 *
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), candidates, 0, 0, target);
        HashSet<List<Integer>> set = new HashSet<>();
        set.addAll(results);
        results.clear();
        results.addAll(set);
        return results;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] candidates, int start, int tempSum, int target ){
        if (tempSum > target) return;
        else if (tempSum == target) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrack(lists, list, candidates, i+1, tempSum+candidates[i], target);
                list.remove(list.size() - 1);
            }
        }
    }
}
