package com.xiaode.BinaryTree;


import java.util.*;

public class PostOrder {
    public List<Integer> result = new ArrayList<Integer>();
    /**
     * Recursive solution
     * @param root
     * @return
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        if( root == null ) return new ArrayList<Integer>();
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }

    /**
     * iterative solution
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        if (root == null) return null;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        nodeStack.push(root);
        List<Integer> res = new ArrayList<>();
        TreeNode pre = null;
        while(nodeStack.size() != 0) {
            TreeNode current = nodeStack.peek();
            if (pre == null || pre.left == current || pre.right == current) {
                if (current.left != null) nodeStack.push(current.left);
                else if (current.right != null) nodeStack.push(current.right);
                else {
                    nodeStack.pop();
                    res.add(current.val);
                }
            } else if (current.left == pre) {
                if (current.right != null) nodeStack.push(current.right);
                else {
                    nodeStack.pop();
                    res.add(current.val);

                }
            } else if (current.right == pre) {
                res.add(current.val);
                nodeStack.pop();
            }
            pre = current;
        }
        return res;
    }
}
