package com.xiaode.MediumSolutions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by liyangde on Jul, 2018
 *
 * 623. Add One Row to Tree
 *
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree
 * root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be
 * the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new
 * root of the whole original tree, and the original tree is the new root's left subtree.
 *
 * Note:
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        insert(v, root, 1, d);
        return root;

    }

    private void insert(int val, TreeNode node, int depth, int n) {
        if (node == null)
            return;
        if (depth == n - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            insert(val, node.left, depth + 1, n);
            insert(val, node.right, depth + 1, n);
        }
    }
}

class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
}