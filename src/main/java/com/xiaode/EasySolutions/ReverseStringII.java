package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 541. Reverse String II
 *
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] seq = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        if(seq.length < k) {

            sb.append(seq);
            return sb.reverse().toString();
        } else if (s.length() >= k && s.length() < 2 * k ) {
            sb.append(s.substring(0,k));
            return sb.reverse().toString() + s.substring(k);
        } else {
            int remains = s.length() % (2 * k);
            for (int i = 0; i <= s.length() - 2 * k; i += (2 * k)) {
                for (int j = k - 1; j >= 0; j--) {
                    sb.append(seq[j+i]);
                }
                for (int j = k; j <= 2 * k - 1; j++) {
                    sb.append(seq[j+i]);
                }
            }
            return remains == 0 ? sb.toString() : sb.toString() + reverseStr(s.substring(s.length() - remains), k);

        }

    }

    public static void main(String[] args) {
        ReverseStringII reverseStringII = new ReverseStringII();
        String result = reverseStringII.reverseStr("abcd", 2);
        System.out.println(result);
    }
}
