package com.xiaode.NAryTree;

import com.xiaode.ADT.Node;

import java.util.*;

/**
 * Created by liyangde on Sep, 2018
 */
public class PostOrder {

    List<Integer> values = new ArrayList<>();

    //recursive
    public List<Integer> postorder(Node root) {
        if (root == null) return Collections.emptyList();
        for (Node node : root.children) postorder(node);
        values.add(root.val);
        return values;
    }

    //iterative
    public List<Integer> postorder2(Node root) {
        return null;
    }

}
