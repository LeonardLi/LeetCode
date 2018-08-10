package com.xiaode.EasySolutions;

/**
 * Created by xiaode on 3/23/17.
 */
public class MinumumDepthOfBinaryTree {
    /**
     * 111. Minimum Depth of Binary Tree
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    public static int minDepth( TreeNode root){
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left+right+1: Math.min(left,right)+1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    String string;
    TreeNode(int x) { val = x;}

    public int getVal() {
        return val;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Object returnNull() {
        return null;
    }
}

