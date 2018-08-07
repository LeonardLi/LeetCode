package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 605. Can Place Flowers
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be
 *
 * planted in adjacent plots - they would compete for water and both would die.
 *
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n,
 *
 * return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 */
public class CanPlaceFlowers {

    //test case 115 / 123 test cases passed.
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //corner case
        if (n == 0) return true;

        if (2 * n - 1 > flowerbed.length) return false;

        if (flowerbed.length == 1) return flowerbed[0] == 0 && n == 1 || flowerbed[0] == 1 && n == 0;

        int existed = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) existed++;
        }

        if (flowerbed.length % 2 == 0) {
            if ((n + existed) * 2 > flowerbed.length ) return false;
            else return true;
        }
        else {
            // if head is not planted
            if ((n + existed) * 2 - 1 <= flowerbed.length && flowerbed[1] != 1) return true;
            else return false;
        }

    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if(count>=n)
                return true;
            i++;
        }
        return false;
    }
}
