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
        int top = -1;
        int flag = 1;
        TreeNode temp = null;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        if(root != null) {
            do {
                while( root != null){
                    top ++;

                }
            }while( top > -1);
        }
        return null;
    }
}
