package com.xiaode.codejam;
import java.util.*;
import java.io.*;
/**
 * Created by liyangde on Apr, 2019
 */

public class Foregone {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        int[] result;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            result = split2(n);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1]);
        }
    }

    private static int[] split2(int n) {
        int[] res = new int[2];
        String number = String.valueOf(n);
        StringBuilder A = new StringBuilder();
        StringBuilder B = new StringBuilder();
        int remainder = 0;
        int num;
        for(char c : number.toCharArray()) {
            num = (c-'0') + remainder;
            remainder = 0;
            if (num == 1) {
                 remainder = 10;
            } else if ( num == 8 || num == 7 || num == 9) {
                A.append(1);
                B.append(num-1);
            } else {
                A.append(num/2);
                B.append(num-num/2);
            }
        }

        res[0] = Integer.valueOf(A.toString());
        res[1] = Integer.valueOf(B.toString());
        return res;
    }


    private static int[] split(int n) {
        int[] res = new int[2];
        for(int i = 1; i < n/2; i++) {
            res[0] = i;
            res[1] = n-i;
            if(set.contains(res[0]) || set.contains(res[1])) continue;
            if(check(res[0]) && check(res[1])) break;
        }

        return res;
    }

    private static boolean check(int i) {
        int number = i;
        while(i>0){
            int remainer = i % 10;
            if (remainer == 4) {
                set.add(number);
                return false;
            }
            else i = i / 10;
        }
        return true;
    }


}

