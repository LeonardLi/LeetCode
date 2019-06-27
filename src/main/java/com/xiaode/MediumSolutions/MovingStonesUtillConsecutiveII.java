package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by liyangde on May, 2019
 */
public class MovingStonesUtillConsecutiveII {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int i = 0, n = stones.length, low = n;
        int high = Math.max(stones[n-1] - n + 2 - stones[1], stones[n-2] - stones[0] - n + 2);
        for (int j = 0; j < n; ++j) {
            while(stones[j] -  stones[i] >= n) ++i;
            if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2)
                low = Math.min(low, 2);
            else
                low = Math.min(low, n - (j - i + 1));
        }
        return new int[]{low, high};
    }
}
