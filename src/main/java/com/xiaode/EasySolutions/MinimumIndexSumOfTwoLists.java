package com.xiaode.EasySolutions;
import java.util.*;

/**
 * Created by liyangde on Sep, 2018
 *
 * 599. Minimum Index Sum of Two Lists
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all
 * of them with no order requirement. You could assume there always exists an answer.
 *
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> count = new HashMap();

        List<String> newList1 = Arrays.asList(list1);
        List<String> newList2 = Arrays.asList(list2);
        Set<String> result = new HashSet<>();

        newList1.stream().forEach(str -> {
            if (newList2.contains(str)) {
                count.put(str, newList1.indexOf(str)+ newList2.indexOf(str));
            }
        });

        int tempMin = Integer.MAX_VALUE;
        String temp = "";
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() < tempMin) {
                temp = entry.getKey();
                tempMin = entry.getValue();
            }

        }

        result.add(temp);
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == tempMin) result.add(entry.getKey());
        }

        return result.toArray(new String[0]);

    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();
        String[] test1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] test2 = {"KFC","Shogun","Burger King"};
        minimumIndexSumOfTwoLists.findRestaurant(test1, test2);
    }




    int sum = Integer.MAX_VALUE;

    public String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> strMap = new HashMap<>();
        List<String> answer = new ArrayList<>();
        int lowestStrIdex = Integer.MAX_VALUE;
        int range = Math.max(list1.length, list2.length);
        int idx = 0;
        while(idx<range && (idx<list1.length || idx<list2.length)){
            int matchedIdx = findMatched(list1, idx, strMap, answer);
            if(matchedIdx < lowestStrIdex){
                lowestStrIdex = matchedIdx;
                range = idx + lowestStrIdex+1;
            }

            matchedIdx = findMatched(list2, idx, strMap, answer);
            if(matchedIdx < lowestStrIdex){
                lowestStrIdex = matchedIdx;
                range = idx + lowestStrIdex+1;
            }

            idx++;
        }

        return answer.toArray(new String[0]);
    }

    int findMatched(String[] list, int idx, Map<String, Integer> strMap, List<String> answer) {
        int matchedIdx = Integer.MAX_VALUE;
        if( idx < list.length){
            String str = list[idx];
            if(strMap.containsKey(str)){
                matchedIdx = strMap.get(str) ;
                int newSum = matchedIdx + idx;
                if(sum > newSum){
                    answer.clear();
                    answer.add(str);
                    sum = newSum;
                }else if(sum == newSum){
                    answer.add(str);
                }
            }else{
                strMap.put(str, idx);
            }
        }
        return matchedIdx;
    }
}
