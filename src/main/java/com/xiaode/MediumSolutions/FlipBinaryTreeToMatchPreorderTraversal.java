package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Jan, 2019
 */
public class FlipBinaryTreeToMatchPreorderTraversal {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null) return Arrays.asList(-1);
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        int ans = 0;
        nodeStack.push(root);
        int p = 0;
        while (nodeStack.size() != 0) {
            TreeNode node = nodeStack.pop();
            if(node.val != voyage[p++]) {
                return Arrays.asList(-1);
            } else {
                if (node.left != null && node.left.val != voyage[p]) {
                    ans++;
                    if (node.left != null) nodeStack.push(node.left);
                    if (node.right != null) nodeStack.push(node.right);
                } else {
                    if (node.right != null) nodeStack.push(node.right);
                    if (node.left != null) nodeStack.push(node.left);
                }

            }

        }
        if (ans!=0) answer.add(ans);
        return answer;

    }


    public List<Integer> preOrderTravesal2(com.xiaode.BinaryTree.TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        Deque<com.xiaode.BinaryTree.TreeNode> nodeStack = new LinkedList<>();
        nodeStack.push(root);

        while(nodeStack.size() != 0) {
            com.xiaode.BinaryTree.TreeNode node = nodeStack.pop();
            res.add(node.val);
            if (node.right != null) nodeStack.push(node.right);
            if (node.left != null) nodeStack.push(node.left);
        }
        return res;
    }
}
