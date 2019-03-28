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

        for (int i=1; i<n; ++i)
        {
            int key = data[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && data[j] > key)
            {
                data[j+1] = data[j];
                j = j-1;
            }
            data[j+1] = key;
        }
    }

    public static void selectSort(int[] data){
        int n = data.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (data[j] < data[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = data[min_idx];
            data[min_idx] = data[i];
            data[i] = temp;
        }
    }


    public static void shellSort(int[] data){
        int n = data.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = data[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && data[j - gap] > temp; j -= gap)
                    data[j] = data[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                data[j] = temp;
            }
        }
    }

    public static void flipSort(int[] data){
        int n = data.length;
        // Start from the complete
        // array and one by one
        // reduce current size by one
        for (int curr_size = n; curr_size > 1; --curr_size)
        {
            // Find index of the
            // maximum element in
            // arr[0..curr_size-1]
            int mi = findMax(data, curr_size);

            // Move the maximum element
            // to end of current array
            // if it's not already at
            // the end
            if (mi != curr_size-1)
            {
                // To move at the end,
                // first move maximum
                // number to beginning
                flip(data, mi);

                // Now move the maximum
                // number to end by
                // reversing current array
                flip(data, curr_size-1);
            }
        }
    }
    // Returns index of the
    // maximum element in
    // arr[0..n-1]
    static int findMax(int arr[], int n)
    {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }

    /* Reverses arr[0..i] */
    static void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    public static void radixSort(){}

    public static void BucketSort(){}


    public static void main(String[] args){
      int[] test = new int[]{2,6,1,3,4,9,8,0,5,7};

      Sort.flipSort(test);
      System.out.println(Arrays.toString(test));

    }
}
