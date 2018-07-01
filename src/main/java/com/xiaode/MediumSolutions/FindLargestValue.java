package com.xiaode.MediumSolutions;

import java.util.*;
import com.xiaode.BinaryTree.TreeNode;

/**
 * Created by xiaode on 2/26/17.
 */
public class FindLargestValue {
    /**
     * 515. Find Largest Value in Each Tree Row
     * You need to find the largest value in each row of a binary tree
     */
    public List<Integer> largestValues(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
        //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }

}
