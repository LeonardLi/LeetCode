package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 *
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 *
 * Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 *
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 *
 *
 * Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 *
 *
 *
 * Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 *
 *
 *
 * Note:
 *
 * The binary tree will have at most 100 nodes.
 * The value of each node will only be 0 or 1.
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        helper(root);
        return root;
    }

    private boolean helper(TreeNode node) {
        if (node == null) return false;

        boolean left = helper(node.left);
        boolean right = helper(node.right);

        if (!left) node.left = null;
        if (!right) node.right = null;

        return node.val == 1 || right || left;
    }

    public static void main(String[] args) {
        BinaryTreePruning b = new BinaryTreePruning();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        b.pruneTree(node1);
    }
}
