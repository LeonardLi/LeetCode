package com.xiaode.HardSolutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


        //corner case
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

    /**
     * Accepted but not good 2080/2080 passed 259ms
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArray2(int[] nums1, int[] nums2) {
        List<Integer> list1 = IntStream.of(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.of(nums2).boxed().collect(Collectors.toList());
        List<Integer> list3 = new ArrayList<>();
        //corner case
        if (list1.size() == 0) {
            list3.addAll(list2);
        } else if (list2.size() == 0) {
            list3.addAll(list1);
        } else {
            list3.addAll(list1);
            list3.addAll(list2);
        }

        list3.sort(Comparator.naturalOrder());
        if (list3.size() % 2 == 0) {
            //even
            return ((double)(list3.get(list3.size()/2)+list3.get(list3.size()/2 - 1))) / 2;
        }else {
            //odd
            return Double.valueOf(list3.get(list3.size()/2));
        }
    }

    public double findMedianSortedArray3(int[] nums1, int [] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;
        return (getkth(nums1,0,nums2,0, l) + getkth(nums1, 0, nums2, 0,r)) / 2.0;
    }
    private double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1 ) return B[bStart + k -1];
        if (bStart > B.length - 1 ) return A[aStart + k -1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 -1 < A.length) aMid = A[aStart + k/2 -1];
        if (bStart + k/2 -1 < B.length) bMid = B[bStart + k/2 -1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart, k - k/2);
        else
            return getkth(A, aStart, B, bStart + k/2, k - k/2);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        int [] a = {1,3,5,7,9};
        int [] b = {2,4,6,8,10};
        System.out.println(m.findMedianSortedArray2(a,b));
    }
}
