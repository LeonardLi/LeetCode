package com.xiaode.HardSolutions;

import java.util.*;

/**
 * Created by liyangde on Nov, 2018
 *
 * 248. Strobogrammatic Number III
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 *
 * Example:
 *
 * Input: low = "50", high = "100"
 * Output: 3
 * Explanation: 69, 88, and 96 are three strobogrammatic numbers.
 * Note:
 * Because the range might be a large number, the low and high numbers are represented as string.
 */
public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int lowLength = low.length();
        int highLength = high.length();
        if (lowLength > highLength) return 0;

        int res = 0;
        if (lowLength < highLength - 1){
            for (int i  = lowLength+1; i <= highLength - 1; i++) {
                if (i % 2 == 0) {
                    res += 4 * Math.pow(5,(i-2)/2);
                } else {
                    res += 12 * Math.pow(5, (i-3)/2);
                }
            }
        }
        if (lowLength == highLength) {
            List<String>  list = findStrobogrammatic2(lowLength);
            for (String s : list ) {
                if (low.compareTo(s) <= 0 &&  high.compareTo(s) >= 0) res++;
            }
        } else {
            List<String> list2 = findStrobogrammatic2(highLength);
            List<String> list1 = findStrobogrammatic2(lowLength);
            for (String s : list1) {
                if (low.compareTo(s) <= 0) res++;
            }
            for (String s : list2) {
                if (high.compareTo(s) >= 0) res++;
            }
        }

        return res;
    }

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
        StrobogrammaticNumberIII s3 = new StrobogrammaticNumberIII();
        System.out.println(s3.strobogrammaticInRange("0","2147483647"));
    }

}
