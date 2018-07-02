package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 686. Repeated String Match
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If
 * no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A
 * repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {

    /**
     *
     * @param A String
     * @param B String
     * @return
     *
     * S1. find at least A times what number that meet the requirements of the questions
     */
    public int repeatedStringMatch(String A, String B) {

        //corner case 1
        //if(A.equals("") || B.equals("")) return -1;

        //corner case 2
        if(A.length() == 1 && B.length() == 1)
        {
            if (A.equals(B)) return 1;
            else return -1;
        }

        //corner case 3
        if(A.length() >= B.length()) {
            if (A.contains(B)) return 1;

            String C = A + A;
            if (C.contains(B)) return 2;
            else return -1;
        }

        //trivial case
        int init = 1;
        String repeatedStr = A;
        while (repeatedStr.length() < B.length()) {
            repeatedStr += A;
            init++;
        }

        if (repeatedStr.contains(B)) return init;
        else if ((repeatedStr+A).contains(B)) return init+1;
        else return -1;

    }

    public static void main(String[] args) {
        RepeatedStringMatch r = new RepeatedStringMatch();
        String A = "abcd";
        String B = "cdabcdab";
        r.repeatedStringMatch(A,B);
    }
}
