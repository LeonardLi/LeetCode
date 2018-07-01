package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 3/23/17.
 */
public class PalindromeLinkedList {
    /**
     * 234. Palindrome Linked List
     * Given a singly linked list, determine if it is a palindrome.
     * Could you do it in O(n) time and O(1) space
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        return head == null || recurse (head, head) != null;
    }

    private static ListNode recurse (ListNode node, ListNode head) {
        if (node == null) return  head;
        ListNode res = recurse (node.next, head);
        if (res == null) return res;
        else if (res.val == node.val) return (res.next == null ? res : res.next);
        else return null;
    }

    public static void main(String[]args){

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

