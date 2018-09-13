package com.xiaode.MediumSolutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by liyangde on Sep, 2018
 *
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 *
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 *
 * The subtree of a node is that node, plus the set of all descendants of that node.
 *
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation:
 *
 *
 *
 * We return the node with value 2, colored in yellow in the diagram.
 * The nodes colored in blue are the deepest nodes of the tree.
 * The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
 * The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
 * Both the input and output have TreeNode type.
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 1 and 500.
 * The values of each node are unique.
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Deque<TreeNode> current = new LinkedList<>();
        Deque<TreeNode> next = new LinkedList<>();
        Deque<TreeNode> pre = null;
        current.push(root);

        while(current.size() != 0){

            while (current.size() != 0){
                TreeNode node = current.pop();
                if (node.right!= null) next.push(node.right);
                if (node.left!= null) next.push(node.left);
            }

            if (next.size() == 0) {

            }
            current = next;
            next = new LinkedList<>();
        }
        return pre.poll();
    }
}
