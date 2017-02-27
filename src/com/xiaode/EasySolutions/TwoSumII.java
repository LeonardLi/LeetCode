package com.xiaode.EasySolutions;

/**
 * Created by leonard on 27/02/2017.
 */
public class TwoSumII {
/**
 * 167. Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, find two numbers
 * such that they add up to a specific target number.The function twoSum should return indices
 * of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 */
public int[] twoSum(int[] numbers, int target){
    int head =0 ;
    int tail = numbers.length-1;
    int[] result = new int[2];
    while(head<tail){
        long temp = numbers[head]+numbers[tail];
        if(temp < target) head++;
        if(temp> target) tail++;
        if(temp == target ) {
            result[0] = head+1;
            result[1] = tail+1;
            break;
        }

    }
    return result;

}
}
