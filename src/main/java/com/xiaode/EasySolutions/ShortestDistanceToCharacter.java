package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 821. Shortest Distance to a Character
 *
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 */
public class ShortestDistanceToCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];

        int currentIndex = S.indexOf(C); //start index

        if (currentIndex == -1) return result;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != C)
                result[i] = Math.abs(currentIndex - i);
            else {
                currentIndex = i;
                result[i] = 0;
            }

        }

        StringBuilder sb = new StringBuilder(S);
        S = sb.reverse().toString();

        currentIndex = S.indexOf(C);
        for (int i = 0; i <S.length(); i++) {
            if (S.charAt(i) != C)
                result[S.length() - i - 1] =
                        result[S.length() - i - 1] > Math.abs(currentIndex-i) ? Math.abs(currentIndex-i): result[S.length() - i - 1];
            else {
                currentIndex = i;
                result[S.length() - i - 1] = 0;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        ShortestDistanceToCharacter sdt = new ShortestDistanceToCharacter();
        String test = "loveleetcode";
        char C = 'e';

        sdt.shortestToChar(test,C);


    }
}
