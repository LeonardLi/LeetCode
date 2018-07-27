package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyangde on Jul, 2018
 *
 * 637. Average of Levels in Binary Tree
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 *
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageLevelsBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {

        LinkedList<TreeNode> temp = new LinkedList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        List<Double> res = new ArrayList<>();

        if (root == null) return null;
        current.add(root);


        while (current.size() != 0) {
            double sum = 0;
            int size = current.size();
            while(current.size() != 0) {

                TreeNode node = current.poll();
                sum += node.val;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }

            }
            res.add(Double.valueOf((double) sum / size));
            current = temp;
            temp = new LinkedList<>();
        }

        return res;
    }

    public static void main(String[] args) {
        AverageLevelsBinaryTree averageLevelsBinaryTree = new AverageLevelsBinaryTree();
        TreeNode A1 = new TreeNode(3);
        TreeNode A2 = new TreeNode(9);
        TreeNode A3 = new TreeNode(20);
        TreeNode A4 = new TreeNode(15);
        TreeNode A5 = new TreeNode(7);
        A1.left = A2;
        A1.right = A3;
        A3.left = A4;
        A3.right = A5;

        averageLevelsBinaryTree.averageOfLevels(A1);
    }
}

