package com.xiaode.MediumSolutions;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by liyangde on Dec, 2018
 */
public class DeleteColumnstoMakeSortedII {

    public int minDeletionSize(String[] A) {
        int length = A[0].length();
        return 0;

    }

    public int[] prisonAfterNDays(int[] cells, int N) {


        int[][]res = new int[15][8];
        res[0] = Arrays.copyOf(cells, cells.length);
        int day = 1;
        while (day <= 14) {
            System.out.println(day+":"+ Arrays.toString(res[day-1]));
            for(int i = 0; i < 8; i++){
                if (i == 0 || i == 7) cells[i] = 0;
                else{
                    if(res[day-1][i-1] == res[day-1][i+1]) cells[i] = 1;
                    else cells[i] = 0;
                }
            }

            res[day] = Arrays.copyOf(cells, cells.length);
            //System.out.println("2pre:"+ Arrays.toString(pre));
            day++;
        }
        //System.out.println(Arrays.toString(res[(N-1)%14+1]));
        return res[N%14+1];
    }

    public int minDeletionSize2(String[] A) {
        Set<Integer> res = new HashSet<>();
        for (String str : A) {
            Set<Integer> tempSet = new HashSet<>();
            int tempMax = str.charAt(0) - 'a';
            for(int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) > str.charAt(i+1)) {
                    tempSet.add(i+1);
                    continue;
                }
                if (str.charAt(i) - 'a' < tempMax) {
                    System.out.println(str);
                    tempSet.add(i);
                }
                else tempMax = str.charAt(i)-'a';
            }

            res.addAll(tempSet);
        }
        return res.size();
    }


    public static void main(String[] args) {
        DeleteColumnstoMakeSortedII d = new DeleteColumnstoMakeSortedII();
        System.out.println(d.minDeletionSize2(new String[]{"baabab"}));
    }
}
