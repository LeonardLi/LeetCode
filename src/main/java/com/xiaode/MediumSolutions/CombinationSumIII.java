package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangde on Nov, 2018
 *
 * 216. Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    // 1-9, k numbers
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        if (n > k * 9 || n < k) return res;
        backtrack(res, new ArrayList<>(), n, 1, k);
        return res;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int target, int start, int size){
        if (list.size() > size ||  target < 0) return;
        else if (list.size() == size && target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = start; i < 10; i++) {
                list.add(i);
                backtrack(lists,list, target - i, i + 1, size);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        CombinationSumIII sumIII = new CombinationSumIII();
        System.out.println(sumIII.combinationSum3(3,7));
    }
}
