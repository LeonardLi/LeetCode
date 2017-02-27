package com.xiaode.EasySolutions;

import java.util.Arrays;

/**
 * Created by leonard on 27/02/2017.
 */
public class AssignCookies {
    /**
     * 455.Assign Cookies
     * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child
     * at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child
     * will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i,
     * and the child i will be content. Your goal is to maximize the number of your content children and output the
     * maximum number.
     */
    public int findContentChildren(int[] g/*children*/, int[] s/*cookies*/){
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;

        for(int j = 0;result<g.length && j<s.length;j++){
           if(g[result]<=s[j]) result++;
        }
        return result;
    }
}
