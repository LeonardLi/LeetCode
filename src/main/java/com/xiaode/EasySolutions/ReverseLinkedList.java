package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 *
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}
