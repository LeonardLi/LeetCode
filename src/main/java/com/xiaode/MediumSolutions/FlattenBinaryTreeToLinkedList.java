package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Sep, 2018
 *
 * 114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten2(TreeNode root) {
        if (root == null) return;
        Map<Integer, TreeNode> store = new HashMap<>();
        traverse(store, root);
        List<Integer> values = new ArrayList<>(store.keySet());
        Collections.sort(values);
        TreeNode pre = store.get(values.get(0)), current = null;
        for (int i = 1; i < store.size(); i++) {
            current = store.get(i);
            pre.right = current;
            pre = current;
        }
    }

    private void traverse(Map<Integer, TreeNode> store, TreeNode root) {
        if (root == null) return;
        store.put(root.val, root);
        traverse(store, root.left);
        traverse(store, root.right);
    }


    //post-order
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
