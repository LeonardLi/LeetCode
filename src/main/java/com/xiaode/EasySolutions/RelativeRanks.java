package com.xiaode.EasySolutions;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by leonard on 25/02/2017.
 */
public class RelativeRanks {
    /**
     * 506. Relatives Ranks
     * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will
     * be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
     */
    public String[] fingRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        int max = 0;
        for (int i : nums) {
            if (i > max) max = i;
        }

        int[] hash = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            hash[nums[i]] = i + 1;
        }

        int place = 1;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                if (place == 1) {
                    result[hash[i] - 1] = "Gold Medal";
                }
                else if (place == 2) {
                    result[hash[i] - 1] = "Silver Medal";
                }
                else if (place == 3) {
                    result[hash[i] - 1] = "Bronze Medal";
                }
                else {
                    result[hash[i] - 1] = String.valueOf(place);
                }
                place ++;
            }
        }
        return result;
    }
}
