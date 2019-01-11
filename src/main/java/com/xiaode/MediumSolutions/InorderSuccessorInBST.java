package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Dec, 2018
 *
 * 285. Inorder Successor in BST
 *
 *Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * Example 1:
 *
 * Input: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * Output: 2
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * Output: null
 *
 */
public class InorderSuccessorInBST {

    //后继
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    //iterative
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            }
            else
                root = root.right;
        }
        return succ;
    }

    //前驱
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode pred = null;
        while (root!= null) {
            if (p.val > root.val) {
                pred = root;
                root = root.right;
            } else
                root = root.left;
        }
        return pred;
    }
}
