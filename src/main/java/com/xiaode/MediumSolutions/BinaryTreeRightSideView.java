package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liyangde on Jul, 2018
 *
 * 199. Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        if (root != null) nodes.add(root);

        TreeNode node;
        while (!nodes.isEmpty()) {
            rightView.add(nodes.peek().val);
            int levelSize = nodes.size();
            for (int i = 0; i < levelSize; i++) {
                node = nodes.poll();

                if (node.right != null) nodes.add(node.right);

                if (node.left != null) nodes.add(node.left);
            }
        }

        return rightView;
    }

}
