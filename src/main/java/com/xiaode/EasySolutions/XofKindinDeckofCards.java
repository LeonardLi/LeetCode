package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liyangde on Nov, 2018
 *
 * 914. X of a Kind in a Deck of Cards
 *
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 *
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 *
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 *
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 *
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 *
 * Note:
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class XofKindinDeckofCards {

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : deck) {
            map.put(number, map.getOrDefault(number,0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        for (int i : list) {
            if (i < 2) return false;
        }
        //Collections.sort(list,Collections.reverseOrder());
        if(ngcd(list.toArray(new Integer[0]), list.size()) <=2) return false;

        return true;
    }
    int ngcd(Integer v[],int n)
    {
        if(n==1)
            return v[0];
        return gcd(v[n-1],ngcd(v,n-1));
    }
    int gcd(int a,int b)
    {
        return b==0?a:gcd(b,a%b);
    }


}
