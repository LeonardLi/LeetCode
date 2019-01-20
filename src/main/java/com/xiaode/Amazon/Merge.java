package com.xiaode.Amazon;

import com.xiaode.ADT.ListNode;

/**
 * Created by liyangde on Jan, 2019
 */
public class Merge {
    public ListNode mergeLists(ListNode head1, ListNode head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.val < head2.val) {
            head1.next = mergeLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLists(head1,head2.next);
            return head2;
        }
    }
}
