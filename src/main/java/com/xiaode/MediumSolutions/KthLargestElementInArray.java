package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Sep, 2018
 *
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N-k];

//        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//        Arrays.sort(newNums, Collections.reverseOrder());
//        int temp = newNums[0];
//        int count = 1;
//        for (int i = 1; i < newNums.length; i++ ){
//            if (temp >= newNums[i]){
//                count++;
//                temp = newNums[i];
//                if (count == k) break;
//            }
//        }
//        return temp;
    }

//    public int findKthLargest2(int[] nums, int k) {
//        int res = 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
//        for (int num : nums) queue.add(num);
//        while(k-- > 0 ) res = queue.poll();
//        return res;
//    }

    public int findKthLargest3(int[] nums, int k) {

        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    //There is a guaranteed O(n) algorithm called Blum-Floyd-Pratt-Rivest-Tarjan

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new MyComparator(new int[]{r0, c0}));
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                queue.add(new int[]{i, j});
            }
        }
        int i = 0;
        while(!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
    }
    class MyComparator implements Comparator<int[]> {
        int[] base;
        MyComparator(int[] b) {
            this.base = b;
        }

        @Override
        public int compare(int[] o1, int[] o2) {
            int dis1 = Math.abs(o1[0] - base[0]) + Math.abs(o1[1] - base[1]);
            int dis2 = Math.abs(o2[0] - base[0]) + Math.abs(o2[1] - base[1]);
            return dis1 - dis2;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        int [] c = new int[costs.length + 1];
        int a = 0, b = 0;
        if (costs[0][0] > costs[0][1]) {
            c[0] = costs[0][1]; b++;
        } else {
            c[0] = costs[0][0]; a++;
        }

        for (int i = 1; i < costs.length; i++) {
            if(a == costs.length / 2) {
                c[i] = c[i-1] + costs[i][1];
            }else if( b == costs.length / 2) {
                c[i] = c[i-1] + costs[i][0];
            } else {
                if (costs[i][0] > costs[i][1]) {
                    b++;
                    c[i] = c[i-1] + costs[i][1];
                } else {
                    a++;
                    c[i] = c[i-1] + costs[i][0];
                }
            }
        }
        return c[costs.length];
    }
    

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int sumA = 0,sumB = 0, l_start,l_end, m_start, m_end;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < L; i++) sumA += A[i];
        for(l_start = 0; l_start <= A.length - L; l_start++){
            if (l_start+1< M) {
                for (m_start = l_start + L; m_start <= A.length - M; m_start++) {
                    sumB = 0;
                    for (int i = 0; i < M; i++) sumB+=A[m_start+i];
                    res = Math.max(sumA+sumB, res);
                }
            } else {
                for (m_start = 0; m_start < A.length - M; m_start++) {
                    sumB=0;
                    if(m_start + M > l_start) {
                        m_start = l_start+L;
                    }
                    for (int i =m_start; i < M; i++) sumB+=A[m_start+i];
                    res = Math.max(sumA+sumB, res);
                }
            }

            if (l_start == A.length-L) break;
            sumA = sumA + A[l_start+L] - A[l_start];
        }

        return res;
    }
}
