package com.xiaode.Contest;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

import java.util.LinkedList;

/**
 * Created by liyangde on Sep, 2018
 *
 * 900. RLE Iterator
 *
 * Write an iterator that iterates through a run-length encoded sequence.
 *
 * The iterator is initialized by RLEIterator(int[] A), where A is a run-length encoding of some sequence.  More specifically, for all even i, A[i] tells us the number of times that the non-negative integer value A[i+1] is repeated in the sequence.
 *
 * The iterator supports one function: next(int n), which exhausts the next n elements (n >= 1) and returns the last element exhausted in this way.  If there is no element left to exhaust, next returns -1 instead.
 *
 * For example, we start with A = [3,8,0,9,2,5], which is a run-length encoding of the sequence [8,8,8,5,5].  This is because the sequence can be read as "three eights, zero nines, two fives".
 *
 *
 *
 * Example 1:
 *
 * Input: ["RLEIterator","next","next","next","next"], [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
 * Output: [null,8,8,5,-1]
 * Explanation:
 * RLEIterator is initialized with RLEIterator([3,8,0,9,2,5]).
 * This maps to the sequence [8,8,8,5,5].
 * RLEIterator.next is then called 4 times:
 *
 * .next(2) exhausts 2 terms of the sequence, returning 8.  The remaining sequence is now [8, 5, 5].
 *
 * .next(1) exhausts 1 term of the sequence, returning 8.  The remaining sequence is now [5, 5].
 *
 * .next(1) exhausts 1 term of the sequence, returning 5.  The remaining sequence is now [5].
 *
 * .next(2) exhausts 2 terms, returning -1.  This is because the first term exhausted was 5,
 * but the second term did not exist.  Since the last term exhausted does not exist, we return -1.
 *
 * Note:
 *
 * 0 <= A.length <= 1000
 * A.length is an even integer.
 * 0 <= A[i] <= 10^9
 * There are at most 1000 calls to RLEIterator.next(int n) per test case.
 * Each call to RLEIterator.next(int n) will have 1 <= n <= 10^9.
 */
public class RLEIterator {

    Node head = new Node(-1,-1);
    Node currentNode = head;


    public RLEIterator(int[] A) {
        for (int i = 0; i <= A.length - 2; i+=2){
            if (A[i]== 0 || A[i+1] < 0) continue;
            currentNode.next = new Node(A[i+1], A[i]);
            currentNode= currentNode.next;
        }
        head = head.next;
    }

    public int next(int n) {
        if (head == null) return -1;
        if (n > head.frequecy){
            while(n > head.frequecy) {
                n = n - (int)head.frequecy;
                head = head.next;
                if (head == null) break;
            }

        }
        if (head == null) return -1;
        //currentSize = currentSize - n;
        head.frequecy = head.frequecy - n;

        return head.value;
    }

    class Node{
        int value;
        long frequecy;
        Node next;
        Node(int value, long frequecy){
            this.value = value;
            this.frequecy = frequecy;
        }
    }

    public static void main(String[] args) {
        int[] A = {3,8,0,9,2,5};
        int[] B = {811,903,310,730,899,684,472,100,434,611};
        RLEIterator rleIterator = new RLEIterator(A);
//        System.out.println(rleIterator.next(358));
//        System.out.println(rleIterator.next(345));
//        System.out.println(rleIterator.next(154));
//        System.out.println(rleIterator.next(265));
//        System.out.println(rleIterator.next(73));
//        System.out.println(rleIterator.next(220));
//        System.out.println(rleIterator.next(138));
//        System.out.println(rleIterator.next(4));
//        System.out.println(rleIterator.next(170));
//        System.out.println(rleIterator.next(88));



        System.out.println(rleIterator.next(2));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(2));
// [null,903,903,730,684,684,684,684,684,684,684]

    }
}


/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */