package com.xiaode.ADT;

/**
 * Created by liyangde on Sep, 2018
 */
public class MyHashSet {
    /** Initialize your data structure here. */

    final Bucket[] buckets = new Bucket[10000];
    public MyHashSet() {

    }

    public void add(int key) {
        int i = idx(key);
        if (buckets[i] == null) buckets[i] = new Bucket();
        ListNode pre = find(buckets[i], key);

        if (pre.next == null)
            pre.next = new ListNode(key);
        else pre.next.val = key;
    }

    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null) return;
        ListNode pre = find(buckets[i], key);
        if (pre.next == null) return;
        pre.next = pre.next.next;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = idx(key);
        if (buckets[i] == null) return false;
        ListNode node = find(buckets[i], key);
        return !(node.next == null);
    }

    private ListNode find(Bucket bucket, int key) {
        ListNode node = bucket.head, pre = null;
        while ( node != null && node.val != key) {
            pre = node;
            node = node.next;
        }
        return pre;
    }
    private int idx(int key) {
        return Integer.hashCode(key) % buckets.length;
    }

    class Bucket {
        final ListNode head = new ListNode(-1);
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
