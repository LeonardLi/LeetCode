package com.xiaode.EasySolutions;

import java.util.Arrays;

/**
 * Created by liyangde on May, 2019
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int res = 0;
        int[] origin  = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        for(int i = 0; i < origin.length; i++) {
            if (origin[i]!= heights[i]) res++;
        }
        return res;
    }
}
