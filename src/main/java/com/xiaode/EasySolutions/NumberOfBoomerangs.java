package com.xiaode.EasySolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyangde on Aug, 2018
 *
 * 447. Number of Boomerangs
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 */
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i!=points.length;i++){
            for(int j=0;j!=points.length;j++){
                if(i==j){
                    continue;
                }
                //calculate distance
                int deltax=points[i][0]-points[j][0];
                int deltay=points[i][1]-points[j][1];
                int square=deltax*deltax+deltay*deltay;
                if(map.containsKey(square)){
                    map.put(square, map.get(square)+1);
                }else{
                    map.put(square,1);
                }
            }
            for(int value:map.values()){//2*C(n,2)
                count+=value*(value-1);
            }
            map.clear();
        }

        return count;
    }
}
