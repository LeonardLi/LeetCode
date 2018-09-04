package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode head = buildTree(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, low, mid - 1);
        node.right = buildTree(nums, mid + 1, high);
        return node;
    }
}

