package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 830. Positions of Large Groups
 *
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 * Note:  1 <= S.length <= 1000
 */
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        if (S.length() < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();

        int start = 0;
        int end = 0;
        int count = 1;
        char temp = S.charAt(0);
        boolean isChecking = true;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != temp) {
                temp = S.charAt(i);
                end = i - 1;

                if (count >= 3) {
                    result.add(Arrays.asList(start, end));
                }
                count = 1;
                start = i;
            } else if (i == S.length() - 1){
                if (++count >= 3) {
                    result.add(Arrays.asList(start, i));
                }
            } else {
                count++;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();
        String test = "aaa";
        positionsOfLargeGroups.largeGroupPositions(test);
    }
}
