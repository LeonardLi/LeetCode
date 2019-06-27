package com.xiaode.ADT;
import java.util.*;
/**
 * Created by liyangde on Jun, 2019
 */

enum Gfg {
    CODE, LEARN, CONTRIBUTE, QUIZ, MCQ
};
public class JavaCollection {

    static ArrayList<Integer> arrayList;
    static LinkedList<Integer> linkedList;
    static ArrayDeque<Integer> arrayDeque;
    static HashSet<Integer> hashSet;
    static TreeSet<Integer> treeSet;
    static EnumSet<Gfg> enumSet;
    static LinkedHashSet<Integer> linkedHashSet;
    static PriorityQueue<Integer> priorityQueue;
    static HashMap<Integer, Integer> hashMap;
    static TreeMap<Integer, Integer> treeMap;
    static EnumMap<Gfg, Gfg> enumMap;
    static LinkedHashMap<Integer, Integer> linkedHashMap;
    static WeakHashMap<Integer, Integer> weakHashMap;
    static IdentityHashMap<Integer, Integer> identityHashMap;

    /**
     * EnumSet is one of the specialized implementation of Set interface for use with enumeration type
     * Few important features of EnumSet are as follows:
     * 1.It extends AbstractSet and implements Set Interface in Java
     * 2.EnumSet class is a member of the Java Collections Framework & is not synchronized
     * 3.It's high performance set implementation, much faster than HashSet.
     * 4.All of the elements in an enum set must come from a single enumeration type taht is specified when the set is
     * created either explicitly or implicitly.
     */
    public static void EnumSetTest() {
        enumSet = EnumSet.of(Gfg.CODE, Gfg.CONTRIBUTE);
        System.out.println(enumSet);
        EnumSet<Gfg> enumSet2 = EnumSet.complementOf(enumSet);
        System.out.println(enumSet2);
        enumSet = EnumSet.allOf(Gfg.class);
        System.out.println(enumSet);
        enumSet = EnumSet.range(Gfg.CODE, Gfg.QUIZ);
        System.out.println(enumSet);
    }

    public static void IdentityHashMapTest() {

    }

    public static void LinkedListTest() {
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        ListIterator<Integer> iterator = linkedList.listIterator();
        while(iterator.hasNext()) {
            if(iterator.next() == 1) iterator.remove();
            if(iterator.next() == 2) iterator.add(3);
        }
        System.out.println(linkedList);
    }

    public static void main(String[] args) {
//        EnumSetTest();
        LinkedListTest();
    }
}
