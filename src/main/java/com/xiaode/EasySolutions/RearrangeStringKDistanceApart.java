package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Jul, 2019
 */

// Test Case 54/57
//public class RearrangeStringKDistanceApart {
//
//    public String rearrangeString(String s, int k) {
//        if(s == null || s.length() == 0 || s.length() == 1) return s;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(char c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0)+1);
//        }
//        SortedSet<Map.Entry<Character, Integer>> entrySet = new TreeSet<>(new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                int res = o2.getValue().compareTo(o1.getValue());
//                return res != 0 ? res : 1;
//            }
//        });
//
//        entrySet.addAll(map.entrySet());
//        Map.Entry<Character, Integer> most = entrySet.first();
//        int count = most.getValue();
//        Character c = most.getKey();
//
//        if ((count-1) * (k) + 1 > s.length() || k > entrySet.size()) return "";
//        StringBuilder[] sbr = new StringBuilder[count];
//        for(int i = 0; i < count; ++i) {
//            sbr[i] = new StringBuilder();
//            sbr[i].append(c);
//        }
//        for (int i = 0; i < count; i++) {
//            for(int j  = 0; j < k; j++) {
//
//            }
//        }
////        int j = 0;
////        int g = 0;
////        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(entrySet);
////        while(j < s.length() - count) {
////            while(entryList.get(g%entryList.size()).getValue() <= 0
////                    || entryList.get(g%entryList.size()).getKey().equals(c)){
////                g++;
////            }
////            Map.Entry<Character, Integer> entry = entryList.get(g%entryList.size());
////            sbr[j%count].append(entry.getKey());
////            entry.setValue(entry.getValue()-1);
////            j++;
////        }
//        String res = "";
//        for (StringBuilder sb : sbr) res+=sb.toString();
//        return res;
//    }
//
//    public static void main(String[] args) {
//        RearrangeStringKDistanceApart r = new RearrangeStringKDistanceApart();
//        System.out.println(r.rearrangeString("aabbcc", 2));
//    }
//}
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for(int i=0;i<length;i++){
            count[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int index = 0;index<length;index++){
            int candidatePos = findValidMax(count, valid, index);
            if( candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = index+k;
            sb.append((char)('a'+candidatePos));
        }
        return sb.toString();
    }

    private int findValidMax(int[] count, int[] valid, int index){
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for(int i=0;i<count.length;i++){
            if(count[i]>0 && count[i]>max && index>=valid[i]){
                max = count[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }
}
