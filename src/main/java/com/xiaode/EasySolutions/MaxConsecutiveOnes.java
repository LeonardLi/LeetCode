package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 2/23/17.
 */
public class MaxConsecutiveOnes {
    /**
     * 485. Max Consecutive Ones
     * Given a binary array, find the maximum number of consecutive 1s in this array.
     * Example 1:
     * Input: [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s.
     * The maximum number of consecutive 1s is 3.
     */
    public int findMaxConsecutiveOnes(int[] nums){
        //corner case
        if (nums.length == 1 && nums[0]==1) return 1;

        int max = 0;
        int temp = 0;
        for (int i: nums) {
            if(i>0){
                temp++;
            }else{
                if(temp>max) max = temp;
                temp=0;
            }
        }
        //attenion: the last temp may be bigger than the max
        return max>temp?max:temp;
    }
}
