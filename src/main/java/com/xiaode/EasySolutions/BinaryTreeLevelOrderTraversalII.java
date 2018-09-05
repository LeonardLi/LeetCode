package com.xiaode.EasySolutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 107. Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ArrayDeque<TreeNode> currentLevel = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        currentLevel.add(root);

        while (currentLevel.size() != 0) {

            for (TreeNode node : currentLevel) {
                level.add(0,node.val);
            }
            result.add(0, level);
            level = new ArrayList<>();
            while (currentLevel.size() != 0) {
                TreeNode node = currentLevel.poll();
                if (node.right != null) nextLevel.add(node.right);
                if (node.left != null) nextLevel.add(node.left);

            }

            currentLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
        }

        return result;
    }
}
