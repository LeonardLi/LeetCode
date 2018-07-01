package com.xiaode.EasySolutions;
import java.util.*;
/**
 * Created by leonard on 25/02/2017.
 */
public class FindDisappearedNumbers {
    /**
     * 448. Find All Numbers Disappeared in an Array
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others
     * appear once.
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does
     * not count as extra space.
     */
    public List<Integer> findDisappearednumbers(int[] nums){
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int []a = new int[nums.length+1];
        for (int i = 1;i <= nums.length;i++){
            a[nums[i-1]]++;
        }
        for(int j = 1; j < a.length;j++){
            if(a[j] == 0) result.add(j);
        }
        return result;

    }
}
