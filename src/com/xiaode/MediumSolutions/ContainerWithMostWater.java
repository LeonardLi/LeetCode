package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaode on 2/26/17.
 */
public class ContainerWithMostWater {
    /**
     * 11. Container With Most Water
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical l
     * ines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with
     * x-axis forms a container, such that the container contains the most water.
     */
    public int maxArea(int[] height){
        int max =0;
        for (int i=0;i<height.length-1;i++){
            for (int j = i+1;j<height.length;j++){
                int temp = Math.min(height[i],height[j]) * Math.abs(i-j);
                if(temp > max) max = temp;
            }
        }
        return max;
    }
    // 48/49 Time limit exceeded


    /**
     *
     *   1 2 3 4 5 6
     * 1 x   - - - o
     * 2 x x - -
     * 3 x x x - -
     * 4 x x x x -
     * 5 x x x x -
     * 6 x x x x x
     *
     * x means not need to count
     * o is the start point,to find a path
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
        int max = 0;
        int i =0,j= height.length-1;
        while(i<j){
            max = Math.max(max, Math.min(height[i],height[j])*(j-i));
            if(height[i]< height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }

}
