package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 */
public class DIStringMatch {

    public int[] diStringMatch(String S) {
        int [] res = new int[S.length()+1];
        int ins = 0;
        int des = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') res[i] = ins++;
            if (S.charAt(i) == 'D') res[i] = des--;
        }
        if (S.charAt(S.length()-1) == 'I') res[S.length()] = ins;
        else res[S.length()] = des;
        return res;
    }
}
