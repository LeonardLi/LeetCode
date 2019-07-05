package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Jul, 2019
 *
 * 398. Random Pick Index
 *
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 */
public class RandomPickIndex {
    HashMap<Integer, List<Integer>> map;
    Random random;

    public RandomPickIndex(int[] nums) {
        random = new Random();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);

        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

//    int[] nums;
//    Random rnd;
//
//    public Solution(int[] nums) {
//        this.nums = nums;
//        this.rnd = new Random();
//    }
//
//    public int pick(int target) {
//        int result = -1;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != target)
//                continue;
//            if (rnd.nextInt(++count) == 0)
//                result = i;
//        }
//
//        return result;
//    }
}
