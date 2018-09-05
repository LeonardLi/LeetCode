package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Sep, 2018
 *
 * 671. Second Minimum Node In a Binary Tree
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node.
 *
 * If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 */
public class SecondMinimumNodeInBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return -1;
        HashSet<Integer> count = new HashSet<>();
        storeValue(root, count);
        if (count.size() <= 1) return -1;
        ArrayList<Integer> countList = new ArrayList<>(count);
        Collections.sort(countList);
        return countList.get(1);

    }

    void storeValue(TreeNode node, Set<Integer> count) {
        count.add(node.val);
        if (node.right != null) storeValue(node.right, count);
        if (node.left != null) storeValue(node.left, count);
    }

    public int findSecondMinimumValue2(TreeNode root) {
        // corner case
        if (root == null || root.left == null && root.right == null) return -1;

        // has 2 children

        //only one child
        return -1;
    }
}
