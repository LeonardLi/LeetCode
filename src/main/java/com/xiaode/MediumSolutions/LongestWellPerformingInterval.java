package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 */
public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int start = 0;
        int end = 0;
        int interval = 0;
        int [] count = new int[2];
        while(end < hours.length) {
            System.out.println("end:"+end+" >8:"+count[1]+" <=8:"+count[0]);

            if(hours[end] > 8){
                count[1]++;
            }else {
                count[0]++;
            }
            while(count[0] > count[1] && start < end) {
                if(hours[start] > 8) {
                    count[1]--;
                }else {
                    count[0]--;
                }
                start++;
            }
            if(count[1] > count[0]) {
                interval = Math.max(interval, end-start+1);
                System.out.println(interval+" start:"+start+" end:"+end);
            }
            end++;
        }
        return interval;
    }

    public static void main(String[] args) {
        LongestWellPerformingInterval l = new LongestWellPerformingInterval();
        l.longestWPI(new int[]{6,9,9});
    }
}
