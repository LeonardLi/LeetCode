package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 530. Minimum Absolute Difference in BST
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceInBST {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev));
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST = new MinimumAbsoluteDifferenceInBST();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(4);

        node1.left = node2;
        node2.left = node3;
        node1.right = node4;
        node4.left = node5;

        System.out.println(minimumAbsoluteDifferenceInBST.getMinimumDifference(node1));

    }
}
