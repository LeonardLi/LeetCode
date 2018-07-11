package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<TreeNode> tree = new ArrayList<>();
        tree.add(new TreeNode(0));

        TreeNode cur = root;



        return null;
    }

    private List<TreeNode> tranform(TreeNode root) {

    }
}
