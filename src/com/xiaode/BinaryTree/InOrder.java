package com.xiaode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    //Recursively
    private List<Integer> result = new ArrayList<>();
    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) return null;
        inOrderTraversal(root.left);
        result.add(root.val);
        inOrderTraversal(root.right);
        return result;
    }
    //Iteratively
    public List<Integer> inOrderTraversal2(TreeNode root) {
        return null;
    }
}
