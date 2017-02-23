package com.xiaode.MediumSolutions;

/**
 * Created by xiaode on 2/23/17.
 */
public class CountingBits {
    /**
     * 338. Counting Bits
     * Given a non negative integer number num. For every numbers i in the range 0 ≤
     * i ≤ num calculate the number of 1's in their binary representation and return
     * them as an array.
     *
     * Example:
     * For num = 5 you should return [0,1,1,2,1,2].
     */
    public int[] countBits(int num){
        //stupid method

        int [] result = new int[num+1];
        result[0] = 0;
        if(num == 0 ) return result;
        for(int i = 1; i<=num; i++){
            int number = i;
            int count = 0;
            while(number!=0){
                if((number &0x01) == 1 ) count++;
                number = number >> 1;
            }
            result[i] = count;
        }
        return result;
    }
    public int[] countBits2(int num){
        int[] f = new int[num+1];
        for (int i=1; i<=num;i++) f[i] = f[i>>1]+ (i & 1);
        return f;
    }
}
