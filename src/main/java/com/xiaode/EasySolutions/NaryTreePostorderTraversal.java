package com.xiaode.EasySolutions;

import com.xiaode.ADT.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangde on Aug, 2018
 *
 * 590. N-ary Tree Postorder Traversal
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePostorderTraversal {

    List<Integer> values = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        // recursive
        if (root == null) return Collections.emptyList();

        //
        for (Node node : root.children) {
            postorder(node);

        }
        //
        values.add(root.val);
        return values;
    }
}
