package com.xiaode.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrder {

    /**
     * Travese the tree using pre order recursively
     * @param root
     * @return
     */

    public List<Integer> preOrderTravesal(TreeNode root, List<Integer> values) {
        if (root == null) return null;
        values.add(root.val);
        preOrderTravesal(root.left, values);
        preOrderTravesal(root.right, values);
        return values;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTravesal2(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.push(root);

        while(nodeStack.size() != 0) {
            TreeNode node = nodeStack.pop();
            res.add(node.val);
            if (node.right != null) nodeStack.push(node.right);
            if (node.left != null) nodeStack.push(node.left);
        }
        return res;
    }
}
