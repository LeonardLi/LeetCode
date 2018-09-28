package com.xiaode.MediumSolutions;

import java.util.HashMap;

/**
 * Created by liyangde on Sep, 2018
 *
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        int index = 0;
        while(temp != null) {
            map.put(index++, temp);
            temp = temp.next;
        }

        if (index - n - 1 < 0){
           head = head.next;
        }
        else {
            ListNode pre = map.get(index - n - 1);
            ListNode target = map.get(index - n);
            pre.next = target.next;
        }


        return head;
    }

    //2 pointer faster
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < n; i++)
            fast = fast.next;

        ListNode prev = null;
        while(fast!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        //remove
        if(prev == null)
            return head.next;
        prev.next  = slow.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}