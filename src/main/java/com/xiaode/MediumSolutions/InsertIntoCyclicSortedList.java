package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Dec, 2018
 *
 * 708. Insert into a Cyclic Sorted List
 *
 * Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.
 *
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.
 *
 * If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.
 *
 * The following example may help you understand the problem better:
 */
public class InsertIntoCyclicSortedList {

    public Node insert(Node head, int insertVal) {
        //corner case 1: null
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        //corner case 2: single node


        //find max and min
        Node current = head;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(true) {
            max = Math.max(max, current.val);
            min = Math.min(min, current.val);
            current = current.next;
            if(current == head) break;
        }

        Node pre = head;
        Node next = head.next;
        if (insertVal >= max || insertVal <= min) {
            while(true) {
                if( pre.val == max && next.val == min) {
                    Node insert = new Node(insertVal, next);
                    pre.next = insert;
                    break;
                } else {
                    pre = next;
                    next = next.next;
                }
            }
        } else {
            //
            while(pre.val > insertVal || next.val < insertVal) {
                pre = next;
                next = next.next;
            }
            Node insert = new Node(insertVal, next);
            pre.next = insert;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
}
