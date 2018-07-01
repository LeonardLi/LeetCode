package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by xiaode on 2/24/17.
 */
public class ConrainsDuplicateII {
    /**
     * 219.Contains Duplicate II
     * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
     * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k){
        HashMap<Integer, ArrayList<Integer>> storage = new HashMap<>();
       for (int i = 0; i< nums.length;i++){
           if (!storage.containsKey(nums[i])){
               ArrayList<Integer> indexes = new ArrayList<>();
               indexes.add(i);
               storage.put(nums[i],indexes);
           }else{
               storage.get(nums[i]).add(i);
           }
       }
        for (int i: storage.keySet()) {
            if(storage.get(i).size()>=2){
                if (getMaxDistance(storage.get(i))<=k){
                    return true;
                }
            }
        }
        return false;
    }
    int getMaxDistance(ArrayList<Integer> nums){
        Collections.sort(nums);
        return nums.get(nums.size()-1)-nums.get(0);
    }
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Set<Integer> set = new HashSet<Integer>();
//        for(int i = 0; i < nums.length; i++){
//            if(i > k) set.remove(nums[i-k-1]);
//            if(!set.add(nums[i])) return true;
//        }
//        return false;
//    }
}
