package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Sep, 2018
 *
 * 589. N-ary Tree Preorder Traversal
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 *
 * For example, given a 3-ary tree:
 *
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePreorderTraversal {

    //recursive
    List<Integer> values = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root != null) values.add(root.val);
        else return Collections.emptyList();

        for (Node node : root.children) {
            preorder(node);
        }
        return values;
    }


    //iterative
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root == null) return result;
        deque.push(root);
        while(!deque.isEmpty()) {
            Node current = deque.pop();
            result.add(current.val);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                deque.push(current.children.get(i));
            }
        }
        return result;
    }

}


