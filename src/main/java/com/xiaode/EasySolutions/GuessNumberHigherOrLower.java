package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 374. Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 *
 */
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        //
        int left = 1;
        int right = n;
        int num = left + (right - left) / 2;
        while(true){
            int result = guess(num);
            if ( result == -1){
                left = num;
                num = left + (right - left) / 2;
            } else if ( result == 1) {
                right = num;
                num = left + (right - left) / 2;
            } else {
                return num;
            }
        }
    }

    private int guess(int num) {
        if (num > 6) return 1;
        else if (num < 6) return -1;
        else if (num == 6) return 0;
        else return 0;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower guessNumberHigherOrLower = new GuessNumberHigherOrLower();
        guessNumberHigherOrLower.guessNumber(10);
    }
}
