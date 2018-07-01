package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leonard on 25/02/2017.
 */
public class RelativeRanks {
    /**
     * 506. Relatives Ranks
     * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will
     * be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
     */
    public String[] fingRelativeRanks(int[] nums){
        String[] strings = {"Gold Medal","Silver Medal","Bronze Medal"};
        String[] result = new String[nums.length];
        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++){
            if(i<=2){
                result[i] = strings[i];
            }else {
                result[i] = String.valueOf(nums[i]);
            }
        }
        return result;
    }
}
