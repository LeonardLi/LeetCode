package com.xiaode.NAryTree;

import com.xiaode.ADT.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 */
public class LevelOrder {
    List<Integer> values = new ArrayList<>();

    //recursive
    public List<Integer> postorderTraversal(Node root) {
        // recursive
        if (root == null) return Collections.emptyList();
        //
        for (Node node : root.children) {
            postorderTraversal(node);
        }
        //
        values.add(root.val);
        return values;
    }

    //iterative
    public List<Integer> postorderTraversal2() {
        return null;
    }
}
