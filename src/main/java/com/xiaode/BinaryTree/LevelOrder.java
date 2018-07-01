package com.xiaode.BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.xiaode.BinaryTree.TreeNode;

/**
 * @author xiaode
 */
public class LevelOrder {
    /**
     * iterate the binary tree by level order
     * using 2 queues to store the current and next level of the tree
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        if (null == root) return null;
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        queue.offer(root);
        int currentCount = queue.size();
        int nextCount = 0;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            while(currentCount > 0){
                TreeNode current = queue.poll();
                currentCount--;
                level.add(current.val);
                if (current.left != null) {
                    nextLevel.offer(current.left);
                    nextCount++;
                }
                if (current.right != null) {
                    nextLevel.offer(current.right);
                    nextCount++;
                }
            }
            result.add(level);
            currentCount = nextCount;
            queue = nextLevel;
            nextCount = 0;

        }

        return result;
    }

}