package com.xiaode.EasySolutions;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 *
 */
public class FindModeInBinarySearchTree {

    int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        HashMap<Integer, Integer> count = new HashMap<>();
        inOrder(root, count);

        List<Integer> list = new LinkedList<>();
        for (int key : count.keySet()) {
            if (count.get(key) == max) list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode node, HashMap<Integer, Integer> count) {
        if (node.left != null) inOrder(node.left, count);
        count.put(node.val, count.getOrDefault(node.val, 0) + 1);
        max = Math.max(max, count.get(node.val));
        if (node.right != null) inOrder(node.right, count);
    }
}
