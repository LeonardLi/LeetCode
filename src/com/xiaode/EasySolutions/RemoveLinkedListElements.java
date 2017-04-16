package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 3/24/17.
 */
public class RemoveLinkedListElements {
    /**
     * 203. Remove Linked List Elements
     */

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val? head.next :head;

    }
}

