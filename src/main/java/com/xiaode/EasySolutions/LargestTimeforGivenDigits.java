package com.xiaode.EasySolutions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liyangde on Dec, 2018
 *
 * 949. Largest Time for Given Digits
 */
public class LargestTimeforGivenDigits {

    String time;
    int[] max = {2, 3, 5, 9};
    public String largestTimeFromDigits(int[] A) {

        int[] cur = new int[4];
        Arrays.fill(cur, -1);

        findLargest(A, new boolean[4], cur, 0);
        return time == null ? "" : time;
    }
    private void findLargest(int[] A, boolean[] used, int[] cur, int pos) {
        if (pos == 4) {
            String s = "" + cur[0] + cur[1] + ":" + cur[2] + cur[3];
            if (time == null || time.compareTo(s) < 0) {
                time = s;
            }
            return;
        }
        if (pos == 1) {
            if (cur[0] == 1 || cur[0] == 0){
                max[1] = 9;
            } else if (cur[0] == 2) {
                max[1] = 3;
            }
        }
        for (int j = 0; j < 4; j++) {
            if (used[j] || A[j] > max[pos]) continue;
            cur[pos] = A[j];
            used[j]  = true;
            findLargest(A, used, cur, pos + 1);
            cur[pos] = -1;
            used[j] = false;
        }
    }
}
