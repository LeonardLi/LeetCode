package com.xiaode.Sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by leonard on 24/03/2017.
 */
public class Sort {

    public static void quickSort(int[] data){
        qsort(data, 0 ,data.length-1);
    }
    public static void qsort(int []data, int start, int end){
        if(start < end) {
            int pivot = partition(data,start,end);
            qsort(data, start, pivot -1);
            qsort(data, pivot+1, end);
        }
    }

    //this function takes last element as pivot, places the pivot element at its correct position in sorted array, and places
    //all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    private static int partition(int[] data, int start, int end) {
        int pivot = data[end];
        int i = start-1;
        for (int j = start; j < end; j++) {
            //if current element is smaller than or equal to pivot
            if (data[j] <= pivot) {
                i++;
                //swap data[i] and data[j]
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        // swap data[i+1] and data[end] (or pivot)
        int temp = data[i+1];
        data[i+1] = data[end];
        data[end] = temp;
        return i+1;
    }

    // mergeSort
    public static void mergeSort(int[] data){
        if (data.length < 2) return;
        int mid = data.length / 2;
        int [] l = new int[mid];
        int [] r = new int[data.length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = data[i];
        }
        for (int i = mid; i < data.length; i++) {
            r[i-mid] = data[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(data, l, r);
    }

    private static void merge(int []data, int[] l , int[] r) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                data[k++] = l[i++];
            } else {
                data[k++] = r[j++];
            }
        }

        while (i < l.length) {
            data[k++] = l[i++];
        }
        while (j < r.length) {
            data[k++] = r[j++];
        }
    }


    // O(n2)
    public static void bubleSort(int[] data){
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }

            }
        }
    }

    public static void insertSort(int[] data){
        int n = data.length;

    }

    public static void selectSort(int[] data){}


    public static void shellSort(int[] data){}

    public static void flipSort(){}

    public static void radixSort(){}

    public static void BucketSort(){}


    public static void main(String[] args){
      int[] test = new int[]{2,6,1,3,4,9,8,0,5,7};

      Sort.bubleSort(test);
      System.out.println(Arrays.toString(test));

    }
}
