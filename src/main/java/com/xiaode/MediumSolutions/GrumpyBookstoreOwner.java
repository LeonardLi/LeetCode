package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on May, 2019
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int directly_satisfied = 0;
        int secretly_satisfied = 0;
        int sum = 0;
        for(int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0 ) {
                directly_satisfied+=customers[i];
                customers[i] = 0;
            }
        }

        for (int i = 0, j = 0; j < customers.length; j++) {
            sum += customers[j];
            if(j - i == X) sum -= customers[i++];
            secretly_satisfied = Math.max(secretly_satisfied, sum);
        }

        return secretly_satisfied + directly_satisfied ;
    }
    public static void main(String[] args) {
        GrumpyBookstoreOwner g = new GrumpyBookstoreOwner();
        System.out.println(g.maxSatisfied(new int[]{1}, new int[]{1}, 1));
    }
}
