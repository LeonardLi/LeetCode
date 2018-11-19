package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Nov, 2018
 * <p>
 * 445. Add Two Numbers II
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {

    // reverse input linked list
    // reuse addTwoNumber I
    // reverse output list
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode res = addTwoNumbers1(l1, l2);
        res = reverse(res);
        return res;
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            temp.val += l1.val + l2.val;
            checkOverflow(temp);

            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 != null) {
                if (temp.next != null) {
                    l2.val += 1;
                    checkOverflow(l2);
                }
                temp.next = l2;
            } else if (l2 == null && l1 != null) {
                if (temp.next != null) {
                    l1.val += 1;
                    checkOverflow(l1);
                }
                temp.next = l1;
            } else if (l1 == null && l2 == null) {
            } else {
                //l1 != null && l2 != null
                if (temp.next == null) temp.next = new ListNode(0);
            }
            temp = temp.next;
        }
        return head;
    }

    private void checkOverflow(ListNode node) {
        while (node != null) {
            if (node.val >= 10) {
                if (node.next != null) node.next.val += 1;
                else node.next = new ListNode(1);
                node.val -= 10;
            }
            node = node.next;
        }
    }
}
