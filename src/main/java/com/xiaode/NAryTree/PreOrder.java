package com.xiaode.NAryTree;

import com.xiaode.ADT.Node;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 */
public class PreOrder {
    List<Integer> values = new LinkedList<>();

    //recursive
    public List<Integer> preorderTraversal(Node root) {
        if (root != null) values.add(root.val);
        else return Collections.emptyList();

        for (Node node : root.children) {
            preorderTraversal(node);
        }
        return values;
    }

    //iterative
    public List<Integer> preorderTraversal2(Node root) {
        if (root == null) return Collections.emptyList();
        LinkedList<Node> nodeStack = new LinkedList<>();
        nodeStack.add(root);

        while(!nodeStack.isEmpty()) {
            Node node = nodeStack.pollFirst();
            values.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; --i) {
                    nodeStack.offerFirst(node.children.get(i));
                }
            }
        }

        return values;
    }

}
