package com.xiaode.ADT;


/**
 * Created by liyangde on Sep, 2018
 */
public class MyHashMap {
    final Bucket[] buckets = new Bucket[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = idx(key);
        if (buckets[i] == null) buckets[i] = new Bucket();
        ListNode pre = find(buckets[i], key);
        if (pre.next == null)
            pre.next = new ListNode(key, value);
        else pre.next.val = value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = idx(key);
        if (buckets[i] == null) return -1;
        ListNode node = find(buckets[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null) return;
        ListNode pre = find(buckets[i], key);
        if (pre.next == null) return;
        pre.next = pre.next.next;
    }

    private ListNode find(Bucket bucket, int key) {
        ListNode node = bucket.head, pre = null;
        while( node != null && node.key != key) {
            pre = node;
            node = node.next;
        }
        return pre;
    }

    private int idx(int key) {
        return Integer.hashCode(key) % buckets.length;
    }

    class Bucket {
        final ListNode head = new ListNode(-1, -1);
    }
    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
