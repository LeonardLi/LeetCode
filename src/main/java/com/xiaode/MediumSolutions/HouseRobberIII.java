package com.xiaode.MediumSolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyangde on Sep, 2018
 *
 * 337. House Robber III
 *
 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:

 Input: [3,2,3,null,3,null,1]

 3
 / \
 2   3
 \   \
 3   1

 Output: 7
 Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:

 Input: [3,4,5,1,3,null,1]

 3
 / \
 4   5
 / \   \
 1   3   1

 Output: 9
 Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root,val);
        return val;
    }
}
