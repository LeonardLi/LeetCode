package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 *
 * 270. Closest Binary Search Tree Value
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 */
public class ClosestBinarySearchTreeValue {

    double distance = Double.MAX_VALUE;
    int min;
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        if (Math.abs((double)root.val -  target) < distance) {
            min = root.val;
            distance = Math.abs((double)root.val -  target);
        }
        closestValue(root.left, target);
        closestValue(root.right, target);

        return min;
    }
    public static void main(String[] args) {
        ClosestBinarySearchTreeValue c = new ClosestBinarySearchTreeValue();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        c.closestValue(node1,3.714286);
    }
}
