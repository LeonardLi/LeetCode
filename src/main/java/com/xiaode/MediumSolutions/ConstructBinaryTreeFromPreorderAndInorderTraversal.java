package com.xiaode.MediumSolutions;

import java.util.HashMap;

/**
 * Created by liyangde on Sep, 2018
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length != preorder.length) return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0; i< inorder.length; i++){
            hm.put(inorder[i], i);
        }
        return buildTreePreIn(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, hm);

    }

    private TreeNode buildTreePreIn(int[] inorder, int istart, int iend, int[] preorder,
                                    int pstart, int pend, HashMap<Integer, Integer> hm) {
        if(pstart > pend || istart > iend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int ri = hm.get(preorder[pstart]);
        TreeNode leftchild = buildTreePreIn(inorder, istart, ri-1, preorder, pstart + 1, pstart+ri-istart, hm);
        TreeNode rightchild = buildTreePreIn(inorder,ri + 1, iend, preorder, pstart + ri-istart + 1, pend, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
