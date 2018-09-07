package com.xiaode.EasySolutions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 559. Maximum Depth of N-ary Tree]
 *
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * For example, given a 3-ary tree:
 *
 * We should return its max depth, which is 3.
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 *
 */
public class MaximumDepthOfNaryTree {

    //level order
    public int maxDepth(Node root) {
        LinkedList<Node> currentLevel = new LinkedList<>();
        LinkedList<Node> nextLevel = new LinkedList<>();

        if (root == null) return 0;
        if (root.children.size() == 0) return 1;

        int count = 1;

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            count++;
            while (!currentLevel.isEmpty()){
                Node node = currentLevel.poll();
                nextLevel.addAll(node.children);
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }

        return count;
    }

    //dfs
    public int maxDepth2(Node root) {
        if (root == null) return 0;
        return dfs(root, 1);
    }

    int dfs(Node node, int depth) {
        if (node.children.size() == 0) {
            return depth;
        }

        int max = 0;

        for (Node n : node.children) {
            max = Math.max(max, dfs(n, depth + 1));
        }

        return max;
    }


}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};