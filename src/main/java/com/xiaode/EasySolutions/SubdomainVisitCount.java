package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liyangde on Aug, 2018
 *
 * 811. Subdomain Visit Count
 *
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 *
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 *
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 */
public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> counts = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String str: cpdomains) {
            String[] splitResult = str.split( " ");

            if (counts.containsKey(splitResult[1])) {
                counts.put(splitResult[1], counts.get(splitResult[1]) + Integer.parseInt(splitResult[0]));
            } else {
                counts.put(splitResult[1], Integer.parseInt(splitResult[0]));
            }

            while (splitResult[1].contains(".")){
                splitResult[1] = splitResult[1].substring(splitResult[1].indexOf(".") + 1);
                if (counts.containsKey(splitResult[1])) {
                    counts.put(splitResult[1], counts.get(splitResult[1]) + Integer.parseInt(splitResult[0]));
                } else {
                    counts.put(splitResult[1], Integer.parseInt(splitResult[0]));
                }
            }
        }

        counts.keySet().stream().forEach(key -> {
            result.add(counts.get(key)+" "+key);
        });


        return result;
    }
    public static void main(String[] args) {
        SubdomainVisitCount svc = new SubdomainVisitCount();
        String[] test = {"9001 discuss.leetcode.com"};
        System.out.println(svc.subdomainVisits(test));


    }
}
