package com.xiaode.EasySolutions;

/**
 * Created by leonard on 25/02/2017.
 */
public class ConstructRectangle {
/**
 * 492. Construct the Rectangle
 *
 */
    public int[] constructRectangle(int area){
        int w = (int)Math.sqrt(area);
        while(area % w !=0) w--;
        return new int[]{area/w, w};
    }
}
