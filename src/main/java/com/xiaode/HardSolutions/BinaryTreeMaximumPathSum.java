package com.xiaode.HardSolutions;

import com.xiaode.BinaryTree.TreeNode;

import java.util.ArrayList;

/**
 * Created by liyangde on Sep, 2018
 *
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 *
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
       int max = Integer.MIN_VALUE;

       max = traverse(root, 0, max);
       return max;

    }

    public int traverse(TreeNode root, int currentSum, int max) {
        if (root == null) return max;
        currentSum += root.val;
        max = Math.max(currentSum, max);


        max = Math.max(traverse(root.left, currentSum, max), traverse(root.right,currentSum,max));
        return max;
    }


    int maxValue;

    public int maxPathSum2(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }


    public static void main(String[] args) {
        TreeNode A1 = new TreeNode(1);
        TreeNode A2 = new TreeNode(2);
        TreeNode A3 = new TreeNode(3);
        A1.left = A2;
        A1.right = A3;

        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        binaryTreeMaximumPathSum.maxPathSum(A1);
    }

}
