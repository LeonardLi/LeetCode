package com.xiaode.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by liyangde on Apr, 2019
 */
public class GoYourOwnWay {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            String path = in.next();
            String result = findUniqueWay(N, path);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String findUniqueWay(int N, String P) {
        //P exist
        String myWay;
        char[][] next = new char[N][N];
        int i = 0, j = 0;
        for (char c : P.toCharArray()) {
            if (c == 'E') {
                 next[i][j] = 'E';
                 j++;
            } else {
                next[i][j] = 'S';
                i++;
            }
        }
        myWay = findWay(N, next, 0, 0, "");
        return myWay;
    }

    private static String findWay(int N, char[][] existed, int i, int j, String path) {
        if (i > N-1 || j > N-1) return path.substring(0,path.length()-1);
        if(i == N-1 && j == N-1){
            return path;
        }
        String temp = null;
        if (existed[i][j] == '\0'){
            if(i < N-1) {
                temp = findWay(N, existed, i+1, j,path+"S");
            }
            if(j < N-1) {
                temp = findWay(N, existed, i, j+1, path+"E");
            }
        } else if (existed[i][j] == 'E'){
                temp = findWay(N, existed, i+1, j, path+"S");
        } else {
                temp = findWay(N, existed, i, j+1, path+"E");
        }

        return temp;
    }
}
