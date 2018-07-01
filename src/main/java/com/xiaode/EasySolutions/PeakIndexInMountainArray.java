package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 */
public class PeakIndexInMountainArray {
/**
 * 852. Peak Index in a Mountain Array
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Note:
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
    public int peakIndexInMountainArray(int[] A) {
        //iterate? maybe exceed time limit
        //could use binary search to accelerate
        int result = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if(A[i] >= A[i+1]) {
                result = i;
                break;
            }
        }
        return result;
        //return peakIndexInMountainArray2(A,A.length/2);
    }

    //not right
    public int peakIndexInMountainArray2(int[] A, int index) {
        int result = -1;
        if (A[index] >= A[index+1] && A[index] >= A[index-1]) return index;
        if (A[index] <= A[index-1])  return peakIndexInMountainArray2(A,index-index/2);
        if (A[index] >= A[index-1]) return peakIndexInMountainArray2(A, index+index/2);
        return result;
    }

    public static void main(String[] args){
        PeakIndexInMountainArray p = new PeakIndexInMountainArray();
        //int[] test = {18,29,38,59,98,100,99,98,90};
        int[] test ={40,48,61,75,100,99,98,39,30,10};
        //int[] test = {0,2,1,0};

        System.out.println(p.peakIndexInMountainArray(test));
    }

}
