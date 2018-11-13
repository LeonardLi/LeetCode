package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liyangde on Nov, 2018
 *
 * 937. Reorder Log Files
 *
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */
public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> numberlogs = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String log : logs) {
            String[] words = log.split(" ");
            if (isNumeric(words[1])) {
                numberlogs.add(log);
            } else {
                letterLogs.add(log);
            }

        }

        letterLogs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] l1= o1.split(" ");
                String[] l2 = o2.split(" ");
                int l = Math.min(l1.length, l2.length);
                for (int i = 1; i < l; i++) {
                    if (l1[i].compareTo(l2[i]) != 0) return l1[i].compareTo(l2[i]);
                }
                return o1.length() < o2.length()? -1 : 1;

            }
        });

        result.addAll(letterLogs);
        result.addAll(numberlogs);
        return result.toArray(new String[0]);
    }
    public  boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        ReorderLogFiles r = new ReorderLogFiles();
        r.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
    }
}
