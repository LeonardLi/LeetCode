package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";

        String str = "11";

        for(int i = 3; i <= n; i++) {
            str += '$';
            int len = str.length();

            int cnt = 1;

            String temp = "";

            char[] arr = str.toCharArray();

            for (int j = 1; j < len; j++) {
                if (arr[j] != arr[j - 1]) {
                    temp += cnt + 0;

                    temp += arr[j - 1];

                    cnt = 1;
                }
                else cnt++;
            }

            str = temp;
        }

        return str;
    }

    public String countAndSay2(int n) {
        // Base cases
        if (n == 1)     return "1";
        if (n == 2)     return "11";

        // Find n'th term by generating
        // all terms from 3 to n-1.
        // Every term is generated
        // using previous term

        // Initialize previous term
        String str = "11";
        for (int i = 3; i <= n; i++)
        {
            // In below for loop, previous
            // character is processed in
            // current iteration. That is
            // why a dummy character is
            // added to make sure that loop
            // runs one extra iteration.
            str += '$';
            int len = str.length();

            int cnt = 1; // Initialize count
            // of matching chars
            String tmp = ""; // Initialize i'th
            // term in series
            char []arr = str.toCharArray();

            // Process previous term
            // to find the next term
            for (int j = 1; j < len; j++)
            {
                // If current character
                // does't match
                if (arr[j] != arr[j - 1])
                {
                    // Append count of
                    // str[j-1] to temp
                    tmp += cnt + 0;

                    // Append str[j-1]
                    tmp += arr[j - 1];

                    // Reset count
                    cnt = 1;
                }

                // If matches, then increment
                // count of matching characters
                else cnt++;
            }

            // Update str
            str = tmp;
        }

        return str;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        countAndSay.countAndSay(4);
        countAndSay.countAndSay2(4);
    }
}
