package com.xiaode.EasySolutions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

/**
 * Created by liyangde on Sep, 2018
 *
 * 101. Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *    1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        //corner case
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;

        //trivial case

        ArrayDeque<TreeNode> currentLevel = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();

        currentLevel.push(root);

        while(currentLevel.size() > 0) {

            while(currentLevel.size() > 0) {
                TreeNode node = currentLevel.poll();
                if (node.right != null) nextLevel.push(node.right);
                if (node.left != null) nextLevel.push(node.left);
            }
            // check symmetric
            if (!isSymmetric(nextLevel)) return false;
            currentLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
        }
        return true;
    }

    private boolean isSymmetric(Deque<TreeNode> list) {
        ArrayDeque<TreeNode> temp = new ArrayDeque<>(list);

        while (temp.size() >= 1) {
            TreeNode head = temp.pollFirst();
            TreeNode tail = temp.pollLast();
            if (head == null || tail == null) return false;
            if (head.val != tail.val) return false;
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public static void  main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        SymmetricTree symmetricTree = new SymmetricTree();
        symmetricTree.isSymmetric(node1);

    }
}
