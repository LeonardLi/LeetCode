package com.xiaode.MediumSolutions;

import java.util.Arrays;

/**
 * Created by liyangde on Sep, 2018
 *
 * 322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    //not right

    int minNumber;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        minNumber = Integer.MAX_VALUE;
        if (backtracking(coins,0, amount,0)) return minNumber;
        return -1;
    }

    private boolean backtracking(int[] coins, long tempSum, int amount, int numbers){
        boolean result = false;
        if (tempSum == amount) {
            minNumber = Math.min(numbers, minNumber);
            return true;
        }
        if (tempSum > amount) return false;

        for (int i = coins.length - 1; i >= 0; i--) {
            result = result || backtracking(coins,tempSum + coins[i], amount, numbers + 1);
        }

        return result;
    }




    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{186,419,83,408}, 6249));
    }
}
