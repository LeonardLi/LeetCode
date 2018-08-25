package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangde on Aug, 2018
 *
 * 257. Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answers = new ArrayList<>();
        if (root != null) searchBT(root,"", answers);
        return answers;

    }

    private void searchBT(TreeNode node, String path, List<String> answers) {
        if (node.left == null && node.right == null) answers.add(path + node.val);
        if (node.left != null) searchBT(node.left,path + node.val + "->", answers);
        if (node.right != null) searchBT(node.right, path + node.val + "->", answers);
    }
}
