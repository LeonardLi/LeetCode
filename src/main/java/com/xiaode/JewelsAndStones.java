package com.xiaode;

/**
 * Created by liyangde on Jul, 2018
 */
public class JewelsAndStones {

    /**
     * 771. Jewels and Stones
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
     * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
     *
     * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
     * so "a" is considered a different type of stone from "A".
     */
    public int numJewelsInStones(String J, String S) {
        //corner case
        int [] counter = new int[130];
        int result = 0;
        if(J.length() == 0 || S.length() == 0) return 0;

        //record letters in S
        for (int i = 0; i < S.length(); i++) {
            counter[S.charAt(i)]++;
        }

        //count the jewels
        for (int j = 0; j < J.length(); j++) {
            result += counter[J.charAt(j)];
        }

        return result;
    }
}
