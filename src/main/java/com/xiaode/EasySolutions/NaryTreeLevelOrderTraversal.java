package com.xiaode.EasySolutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * 429. N-ary Tree Level Order Traversal
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example, given a 3-ary tree:
 *
 * We should return its level order traversal:
 *
 *
 *
 *
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> currentNumber = new ArrayList<>();
        ArrayList<Node> current = new ArrayList<>();
        ArrayList<Node> next = new ArrayList<>();

        if (root == null) return Collections.emptyList();

        current.add(root);

        while( current.size() != 0 ) {
            while ( current.size()!= 0 ) {
                Node node = current.remove(0);
                currentNumber.add(node.val);
                for (Node child : node.children) {
                    next.add(child);
                }
            }
            res.add(currentNumber);
            currentNumber = new ArrayList<>();
            current = next;
            next = new ArrayList<>();
        }
        return res;
    }
}

