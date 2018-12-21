package com.xiaode.Sort;

import java.util.Arrays;

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

    public static void mergeSort(int[] data){}

    public static void bubleSort(int[] data){}

    public static void insertSort(int[] data){}

    public static void selectSort(int[] data){}

    public static void shellSort(int[] data){}


    public static void main(String[] args){
      int[] test = new int[]{2,6,1,3,4,9,8,0,5,7};

      Sort.quickSort(test);
      System.out.println(Arrays.toString(test));

    }
}
