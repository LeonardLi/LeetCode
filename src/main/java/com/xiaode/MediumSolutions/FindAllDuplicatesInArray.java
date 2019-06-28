package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangde on Jun, 2019
 * 442. Find All Duplicates in an Array
 */
public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        int[] count = new int[nums.length+1];
        List<Integer> res = new ArrayList<>();
        for (int n : nums) count[n]++;
        for (int i = 0; i < nums.length+1; i++) {
            if (count[i] > 1) res.add(i);
        }
        return res;
    }

    //use +/- to store the frequency
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) res.add(Math.abs(index+1));
            nums[index] *= -1;
        }
        return res;
    }
}
