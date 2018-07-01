package com.xiaode.EasySolutions;

/**
 * Created by leonard on 30/04/2017.
 * 543.Diameter of Binary Tree
 *
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        //corner case
        if(root == null) return 0;
        if(root.right == null && root.left == null) return 0;

        //only right children
        if (root.left == null) return depthOfChild(root.right);

        //only left children
        if (root.right == null) return depthOfChild(root.left);
        //both right and left children
        return depthOfChild(root.left) + depthOfChild(root.right);
    }
    public int depthOfChild(TreeNode root){
        if(root == null) return 0;
        int depthLeft = depthOfChild(root.left);
        int depthRight = depthOfChild(root.right);
        return depthLeft > depthRight ? (depthLeft+1) : (depthRight+1);
    }
    // 105/108

    int max = 0;

//    public int diameterOfBinaryTree(TreeNode root) {
//        maxDepth(root);
//        return max;
//    }
//
//    private int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//
//        max = Math.max(max, left + right);
//
//        return Math.max(left, right) + 1;
//    }
}
