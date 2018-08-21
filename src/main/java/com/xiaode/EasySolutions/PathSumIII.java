package com.xiaode.EasySolutions;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by liyangde on Aug, 2018
 *
 * 437. Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {


    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> count = new HashMap<>();
        count.put(0,1);
        return traverse(root, 0 , sum, count);

    }

    //not right
    private int traverse(TreeNode node, int currentSum, int target, HashMap<Integer, Integer> preSum) {

        if (node == null) return 0;
        currentSum += node.val;

        int res = preSum.getOrDefault(currentSum - target, 0);

        preSum.put(currentSum, preSum.getOrDefault(currentSum,0) + 1);

        res += traverse(node.left, currentSum, target, preSum) + traverse(node.right, currentSum, target, preSum);
        preSum.put(currentSum,preSum.get(currentSum) - 1);
        return res;
//        if (node.left == null && node.right == null) return node.val;
//        if (node.left != null) {
//            path = traverse(node.left)+ node.val;
//            if (count.containsKey(path)){
//                count.put(path, count.get(path) + 1);
//            } else {
//                count.put(path, 1);
//            }
//        }
//        if (node.right != null){
//            path = traverse(node.right)+ node.val;
//            if (count.containsKey(path)){
//                count.put(path, count.get(path) + 1);
//
//            } else {
//                count.put(path, 1);
//            }
//
//        }
//        return path;
    }

    public static void main(String[] args) {
        PathSumIII ps = new PathSumIII();
        TreeNode A1 = new TreeNode(10);
        TreeNode A2 = new TreeNode(5);
        TreeNode A3 = new TreeNode(-3);
        TreeNode A4 = new TreeNode(3);
        TreeNode A5 = new TreeNode(2);
        TreeNode A6 = new TreeNode(11);
        TreeNode A7 = new TreeNode(3);
        TreeNode A8 = new TreeNode(-2);
        TreeNode A9 = new TreeNode(1);

        A1.left = A2;
        A1.right = A3;
        A2.left = A4;
        A2.right = A5;
        A3.right = A6;
        A4.left = A7;
        A4.right = A8;
        A5.right = A9;

        ps.pathSum(A1, 8);
    }

}
