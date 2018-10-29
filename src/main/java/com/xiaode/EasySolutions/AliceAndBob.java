package com.xiaode.EasySolutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyangde on Oct, 2018
 *
 * It is so boring in the summer holiday, isn't it? So Alice and Bob have invented a new game to play. The rules are as follows.
 *
 * First, they get a set of n distinct integers. And then they take turns to make the following moves. During each move, either
 *
 * Alice or Bob (the player whose turn is the current) can choose two distinct integers x and y from the set, such that the set
 *
 * doesn't contain their absolute difference |x - y|. Then this player adds integer |x - y| to the set (so, the size of the set
 *
 * increases by one).If the current player has no valid move, he (or she) loses the game. The question is who will finally win
 *
 * the game if both players play optimally. Remember that Alice always moves first.
 *
 * Input
 * The first line contains an integer n (2 ≤ n ≤ 100) — the initial number of elements in the set. The second line contains n distinct space-separated integers a1, a2, ..., an (1 ≤ ai ≤ 109) — the elements of the set.
 *
 * Output
 * Print a single line with the winner's name. If Alice wins print "Alice", otherwise print "Bob" (without quotes).
 */
public class AliceAndBob {

    String playGame(HashSet<Integer> numbers){
        //Alice always first
        int n = 0;
        while (checkSet(numbers)) {
            n++;
        }
        return n % 2 == 0 ?  "Bob":"Alice";
    }

    boolean checkSet(HashSet<Integer> set){
        Integer[] numbers = set.stream().toArray(Integer[]::new);
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (!set.contains(Math.abs(numbers[i]- numbers[j]))) {
                    set.add(Math.abs(numbers[i]- numbers[j]));
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        AliceAndBob aliceAndBob = new AliceAndBob();
        System.out.println(aliceAndBob.playGame(new HashSet<>(Arrays.asList(5,6,7))));
    }
}
