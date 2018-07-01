package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 4/5/17.
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * 160. Intercection of Two Linked Lists
     * Write a program to find the node at which the intersection of two singly linked lists begins
     * @param headA
     * @param headB
     * @return
     */
    public ListNodeA getIntersectionNode(ListNodeA headA, ListNodeA headB){
        if (headA == null || headB == null ) return null;
        while(headA != null){
            while(headB != null){
                if (headB == headA) return headB;
                headB = headB.next;
            }
            headA = headA.next;
        }
        return null;
    }


    //这个方法很巧妙，使用两次迭代。第一次遍历后，短的那条游标指向了长的链表，并向前进了n步，第二次遍历开始
    //时，通过以上的步骤，变成了两个相同长度的链表，此时必然同时到达intersection的位置。
    public ListNodeA getIntersectionNodeA(ListNodeA headA, ListNodeA headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNodeA a = headA;
        ListNodeA b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
class ListNodeA{
    int val;
    ListNodeA next;
    ListNodeA(int x){
        val = x;
        next = null;
    }
}