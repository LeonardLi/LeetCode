package com.xiaode.ADT;

import jdk.internal.dynalink.linker.ConversionComparator;

import java.nio.BufferUnderflowException;

/**
 * Created by liyangde on Jul, 2018
 */
public class BinarySearchTree<T extends Comparable<? super T>> {


    /**
     *
     * @param <T>
     */
    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element) {
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> lt, BinaryNode<T> rt) {
            this.element = element;
            left = lt;
            right = rt;
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    //interface
    /*===============================================*/

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMax() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public T findMin() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public void insert(T x) {
        root = insert(x,root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {
        printTree(root);
    }

    /*===============================================*/

    /**
     * @param x
     * @param t
     * @return
     */
    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null) return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true; //match
    }

    /**
     * Internal method to find the smallest item in a subtree
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t ==  null)
            return null;
        else if (t.left == null)
            return t;
        else return findMin(t.left);
    }


    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode t) {
        if (t != null)
            while(t.right != null)
                t = t.right;
        return t;
    }

    /**
     * Internal method to insert new item to a subtree.
     * @param x
     * @param t
     * @return
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t ==  null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);

        else;
        return t;
    }


    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if ( t == null)
            return t;
        int comparaResult = x.compareTo(t.element);

        if(comparaResult < 0)
            t.left = remove(x, t.left);
        else if(comparaResult > 0)
            t.right = remove(x, t.right);
        else if(t.left != null && t.right != null) { //2 children
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        }
        else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }


    private void printTree(BinaryNode root) {}

    /*===============================================*/


}
