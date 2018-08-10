package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by liyangde on Aug, 2018
 *
 * 872. Leaf-Similar Trees
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();
        iterateLeaves(root1, seq1);
        iterateLeaves(root2, seq2);

        return seq1.equals(seq2);
    }

    private void iterateLeaves(TreeNode node, List<Integer> seq) {

        if (node.left == null && node.right == null) {
            seq.add(node.val);
        }
        if (node.left != null) iterateLeaves(node.left, seq);
        if (node.right != null) iterateLeaves(node.right, seq);

    }

    public Integer testOptional(TreeNode node ){
        return (Integer) Optional.ofNullable(node)
                .filter((n)->n.string.equals("test1"))
                .map(TreeNode::returnNull)
                .orElse(node.getVal());
    }

    public static void main(String[] args) {
        LeafSimilarTrees lst = new LeafSimilarTrees();
        TreeNode a = new TreeNode(1);
        a.setString("test");
        Integer b= lst.testOptional(a);
    }
}
