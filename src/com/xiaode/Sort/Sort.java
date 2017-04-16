package com.xiaode.Sort;

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

    private static int partition(int[] data, int start, int end) {
        int pivot = data[start];
        while (start < end) {
            while (start < end && data[start]>= pivot) --end;
            data[start] =  data[end];
            while (start < end && data[end] <= pivot) ++start;
            data[end] = data[start];
        }
        data[start] = pivot;
        return start;
    }
}
