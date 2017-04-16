package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 3/24/17.
 */
public class MergeSortedArray {
    /**
     * 88. Merge Sorted Array
     *Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums3 = new int[m+n];
        int index1 = 0, index2 = 0, index3  =0;
        while(index1 < m || index2 < n){
            if( index1 < m && nums1[m] <= nums2[n] ){
                nums3[index3++] = nums1[index1++];
            }else if (index2 < n){
                nums3[index3++] = nums2[index2++];
            }
        }

        for (int i  = 0; i< nums3.length; i++){
            nums1[i] = nums3[i];
        }

        // while(n>0) nums1[m+n-1]=(m==0||nums2[n-1]>nums1[m-1])?nums2[--n]:nums1[--m];
    }
}

