package com.xiaode.MediumSolutions;

import java.util.Stack;

/**
 * Created by liyangde on Nov, 2018
 *
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 * You may assume each number in the sequence is unique.
 *
 * Consider the following binary search tree:
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * Example 1:
 *
 * Input: [5,2,6,1,3]
 * Output: false
 * Example 2:
 *
 * Input: [5,2,1,3,6]
 * Output: true
 * Follow up:
 * Could you do it using only constant space complexity?
 */
public class VerifyPreorderSequenceinBinarySearchTree {

    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();

        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }

    //O(1) space
    public boolean verifyPreorder2(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }
}
