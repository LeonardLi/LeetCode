package com.xiaode.ADT;

/**
 * Created by liyangde on Sep, 2018
 */
public class MyLinkedList {
    private Node head, tail;
    private int size = 0;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index+1 > size) return -1;
        if (index+1 == size) return tail.val;
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = head.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        //Node temp = head;
        if (head != null){
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail != null){
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);

        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        newNode.next = temp;
        newNode.pre = temp.pre;
        temp.pre.next = newNode;
        temp.pre = newNode;

        size++;
    }


    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) return;
        if (index == 0) {
            head = head.next;
            head.pre = null;
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.pre;
            tail.next = null;
            size--;
            return;
        }

        Node temp = head;
        for (int i = 1; i <= index; i++){
            temp = temp.next;
        }

        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
        size--;
    }

    class Node{
        Node next,pre;
        int val;
        Node(int val){this.val = val;}
    }

    public static void main(String[] args) {

         // Your MyLinkedList object will be instantiated and called as such:
          MyLinkedList obj = new MyLinkedList();
          obj.addAtHead(5);
          obj.addAtHead(2);
          obj.deleteAtIndex(1);
          obj.addAtIndex(1,9);
          obj.addAtHead(4);
          obj.addAtHead(9);
          obj.addAtHead(8);
          obj.get(3);
          obj.addAtTail(1);
          obj.addAtIndex(3,6);
          obj.addAtHead(3);

    }
}
