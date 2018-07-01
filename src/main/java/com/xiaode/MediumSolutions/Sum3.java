package com.xiaode.MediumSolutions;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Given an arrya S of n integers, are there elements a,b,c in S such that a + b + c = 0? Find all unique triplets in the
 * array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int [] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // iterate
        //
        if (nums.length < 3) return result;

        for (int i = 0 ; i < nums.length - 2; i++){
            for (int j = i+1;j < nums.length - 1; j++  ){
                for (int k = j+1; k < nums.length; k++ ){
                    int sum = nums[i] + nums[j] + nums[k];
                    if ( sum == 0 ) result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        for (int i = 0; i < result.size() - 1; i++ ) {
            for (int j = result.size() - 1; j > i; j--) {
                if (isSameList(result.get(j),result.get(i)))
                    result.remove(j);
            }
        }
        return result;
    }
    private boolean isSameList(List<Integer> l1, List<Integer> l2) {
        for (Integer i : l1) {
            if (!l2.contains(i)) return false;
        }
        for (Integer j : l2) {
            if (!l1.contains(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Sum3 s = new Sum3();
        s.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
    }
}
