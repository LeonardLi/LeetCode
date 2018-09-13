package com.xiaode.BinaryTree;

import java.util.*;

import com.xiaode.BinaryTree.TreeNode;

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
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || nodeStack.size() > 0) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            res.add(current.val);
            current = current.right;
        }
    }
}
