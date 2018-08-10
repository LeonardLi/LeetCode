package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 876. Middle of the Linked List
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode single = head;
        ListNode twice = head;

        while (twice != null && twice.next != null) {
            single = single.next;
            twice = twice.next.next;
        }
        return single;

    }
}
