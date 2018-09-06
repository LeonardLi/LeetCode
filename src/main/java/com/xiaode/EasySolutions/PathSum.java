package com.xiaode.EasySolutions;

import java.util.HashMap;

/**
 * Created by liyangde on Sep, 2018
 *
 * 112. Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    boolean exsisted = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        //HashMap<Integer, Boolean> exsited = new HashMap<>();
        //exsited.put(1, false);
        travelTree(root, 0, sum);
        return exsisted;
    }

    private void travelTree(TreeNode node, int tempPath,int sum) {
        if (node.right == null && node.left == null) if (tempPath + node.val == sum) exsisted = true;
        if (node.right != null)  travelTree(node.right,tempPath + node.val, sum);
        if (node.left != null)  travelTree(node.left, tempPath + node.val, sum);
    }
}
