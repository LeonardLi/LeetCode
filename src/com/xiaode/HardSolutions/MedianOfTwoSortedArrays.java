package com.xiaode.HardSolutions;

/**
 * Created by leonard on 02/03/2017.
 */
public class MedianOfTwoSortedArrays {
    /**
     * 4. Median of Two Sorted Arrays
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the twol run sorted arrays. The overal time complexity should be O(log (m+n)).
     */
    public double findMedianSortedArray(int[] nums1, int[] nums2){

        if(nums1.length == 0){
            if(nums2.length %2 ==0){
                //even
                return (double)(nums2[nums2.length/2]+nums2[nums2.length/2-1])/2;
            }else{
                //odd
                return (double)nums2[nums2.length/2];
            }
        }
        if(nums2.length == 0){
            if(nums1.length %2 ==0){
                //even
                return (double)(nums1[nums1.length/2]+nums1[nums1.length/2-1])/2;
            }else{
                //odd
                return (double)nums1[nums1.length/2];
            }
        }
        int total = nums1.length + nums2.length;
        double median = 0.0;
        if(total %2 ==0){
            //even
            int j=0,k=0;
            int temp= 0;
            for (int i = 1; i<= total/2;i++){
                if(nums1[j<nums1.length-1?j:nums1.length-1]<nums2[k<nums2.length-1?k:(nums2.length-1)]){
                    j++;
                }else{
                    k++;
                }
                if (i == total/2 -1){
                    temp = nums1[j<nums1.length-1?j:nums1.length-1]<nums2[k<nums2.length-1?k:(nums2.length-1)]?nums1[j<nums1.length-1?j:nums1.length-1]:nums2[k<nums2.length-1?k:(nums2.length-1)];
                }
            }
            median = (double)(temp+(nums1[j<nums1.length-1?j:nums1.length-1]<nums2[k<nums2.length-1?k:(nums2.length-1)]?nums1[j<nums1.length-1?j:nums1.length-1]:nums2[k<nums2.length-1?k:(nums2.length-1)]))/2;
        }else { 
            //odd
            int j=0,k=0;
            for (int i = 1; i<= total/2+1;i++){
                if(nums1[j<nums1.length-1?j:nums1.length-1]<nums2[k<nums2.length-1?k:(nums2.length-1)]){
                    j++;
                }else{
                    k++;
                }
            }
            median = nums1[j<nums1.length-1?j:nums1.length-1]<nums2[k<nums2.length-1?k:(nums2.length-1)]?nums1[j<nums1.length-1?j:nums1.length-1]:nums2[k<nums2.length-1?k:(nums2.length-1)];
        }
        return median;
    }

}
