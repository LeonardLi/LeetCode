package com.xiaode.MediumSolutions;

import com.xiaode.EasySolutions.StrobogrammaticNumber;

import java.util.*;

/**
 * Created by liyangde on Nov, 2018
 *
 * 247. Strobogrammatic Number II
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * Example:
 *
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 *
 */
public class StrobogrammaticNumberII {

//    public List<String> findStrobogrammatic(int n) {
//        List<String> res = new ArrayList<>();
//        for(int i = (int)Math.pow(10,n-1); i < (int)Math.pow(10,n); i++) {
//            if(isStrobogrammatic(""+i)) res.add(""+i);
//        }
//        if (n == 1) res.add(0,"0");
//        return res;
//    }
//
//    private boolean isStrobogrammatic(String num) {
//        int start = 0;
//        int end = num.length() - 1;
//        while (start <= end) {
//            switch(num.charAt(start)) {
//                case '0':
//                case '1':
//                case '8':
//                    if (num.charAt(end) != num.charAt(start)) {
//                        return false;
//                    }
//                    break;
//                case '6':
//                    if (num.charAt(end) != '9') {
//                        return false;
//                    }
//                    break;
//                case '9':
//                    if (num.charAt(end) != '6') {
//                        return false;
//                    }
//                    break;
//                default:
//                    return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> findStrobogrammatic2(int n) {
        List<String> res = new ArrayList<>();
        map.put(1, Arrays.asList("0","1","8"));
        map.put(2, Arrays.asList("11","69","88","96"));
        map.put(3, Arrays.asList("609","906","808","101", "111", "181", "619", "689", "818", "888", "916", "986"));

        String[] pairs = {"69","96","88", "11","00"};
        if (n > 3 && map.get(n) == null) constructAns(n, pairs);
        return map.get(n);
    }

    private void constructAns(int n, String[] pairs) {
        if(map.get(n - 2) == null) {
            constructAns(n - 2, pairs);
        }
        List<String> list1 = map.get(n - 2);
        List<String> list2 = new ArrayList<>();
        for (String str : list1) {
            for (String pair : pairs) {
                String newStr;
                if (n % 2 == 0) {
                    //even
                    newStr = str.substring(0,str.length()/2) + pair + str.substring(str.length() / 2);
                } else {
                    //odd
                    newStr = str.substring(0,str.length()/2) + pair.charAt(0) + str.charAt(str.length()/2) + pair.charAt(1) + str.substring(str.length()/2 + 1);
                }
                list2.add(newStr);
            }

        }
        map.put(n, list2);

    }

    public static void main(String[] args) {
        StrobogrammaticNumberII strobogrammaticNumberII = new StrobogrammaticNumberII();
        System.out.println(strobogrammaticNumberII.findStrobogrammatic2(6));
        //System.out.println(strobogrammaticNumberII.findStrobogrammatic(6).size());

    }
}
