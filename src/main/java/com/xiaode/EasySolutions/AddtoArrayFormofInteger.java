package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Feb, 2019
 *
 * 989. Add to Array-Form of Integer
 */
public class AddtoArrayFormofInteger {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int next = 0;
        for(int i = A.length - 1; i >=0; i--) {
            int n = 0;
            int m = 0;
            if (K > 0) {
                n = K % 10;
                K = K / 10;
            }

            m = A[i]+n + next;
            if (next != 0) next = 0;

            if (m >= 10) {
                next = 1;
                m-=10;
            }

            res.add(0, m);
        }
        while(K > 0) {
            int n = K % 10;
            int m = 0;
            K = K /10;

            m = n+next;
            if (next != 0) next = 0;
            if (m >= 10) {
                next = 1;
                m -=10;
            }

            res.add(0, m);
        }

        if (next !=0) res.add(0,1);

        return res;
    }

    public static void main(String[] args) {
        AddtoArrayFormofInteger a = new AddtoArrayFormofInteger();
        System.out.println(a.addToArrayForm(new int[]{7}, 993));
        HashSet<Character> set = new HashSet<>();
    }



}
