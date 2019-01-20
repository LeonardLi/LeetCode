package com.xiaode.Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyangde on Jan, 2019
 * <p>
 * 138. Copy List with Random Pointer
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> store = new HashMap<>();
        RandomListNode cursor = head;
        RandomListNode tempPre = null;
        RandomListNode temp = null;

        //init HashMap
        while (cursor != null) {
            temp = new RandomListNode(cursor.label);
            if (tempPre != null) {
                tempPre.next = temp;
            }
            store.put(cursor, temp);
            tempPre = temp;
            cursor = cursor.next;
        }

        //copy random referrence
        cursor = head;
        while (cursor != null) {
            if (cursor.random != null) {
                store.get(cursor).random = store.get(cursor.random);
            }
            cursor = cursor.next;
        }


        return store.get(head);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
