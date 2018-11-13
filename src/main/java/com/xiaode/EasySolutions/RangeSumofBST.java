package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 */
public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        return helper(root, L, R, 0);
    }

    private int helper(TreeNode node, int L, int R, int temp) {
        if (node.val >= L  && node.val <= R) temp = temp+ node.val;
        if (node.left != null && node.val >= L )  helper(node.left, L, R, temp);
        if (node.right != null && node.val <= R ) helper(node.right, L, R, temp);
        return temp;
    }
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(18);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        RangeSumofBST rangeSumofBST = new RangeSumofBST();
        rangeSumofBST.rangeSumBST(node1, 7, 15);

    }
}
