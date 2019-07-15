package com.xiaode.MediumSolutions;

import java.util.Stack;

/**
 * Created by liyangde on Jul, 2019
 */
public class LowestCommonAncestorofDeepestLeaves {
    class ReturnVal {
        public int depth;
        public TreeNode lca;
        public ReturnVal(int d, TreeNode n) {
            depth = d;
            lca = n;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ReturnVal res = find(root);
        return res.lca;

    }

    private ReturnVal find(TreeNode root) {
        if(root == null) {
            return new ReturnVal(0, null);
        } else {
            ReturnVal lRes = find(root.left);
            ReturnVal rRes = find(root.right);
            if (lRes.depth == rRes.depth) {
                return new ReturnVal(lRes.depth+1, root);
            } else {
                return new ReturnVal(Math.max(rRes.depth, lRes.depth)+1, rRes.depth>lRes.depth?rRes.lca:lRes.lca);
            }
        }

    }
}
