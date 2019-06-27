package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liyangde on Jun, 2019
 */
public class StatisticsfromLargeSample {
    public double[] sampleStats(int[] count) {
        double[] res = new double[5];
        boolean isMinFound = false;
        double sum = 0;
        int cnt = 0;
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <=255; i++) {
            if(count[i] != 0) {
                if (!isMinFound) {
                    res[0] = i;//min
                    isMinFound = true;
                }
                res[1] = i; // max
                sum += i * count[i];
                num += count[i];
                if(count[i] >= cnt) {
                    cnt = count[i];
                    res[4] = i; //mode
                }

                int n = i;
                while(n-- > 0) list.add(count[i]); //median
            }
        }
        res[2] = sum/num;
        if (num % 2 == 0) {
            //average of num/2-1, num/2
            res[3] = ((double)list.get(num/2-1) + (double)list.get(num/2))/2;
        } else {
            //num/2
            res[3] = list.get(num/2);
        }

        //minimum, maximum, mean, median, mode
        return res;
    }
}
