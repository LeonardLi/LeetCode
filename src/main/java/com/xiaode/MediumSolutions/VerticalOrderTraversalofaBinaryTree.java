package com.xiaode.MediumSolutions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liyangde on Feb, 2019
 *
 * 987. Vertical Order Traversal of a Binary Tree
 */
public class VerticalOrderTraversalofaBinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Position>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(map, root, 0, 0);
        for (int key : map.keySet()) {
            List<Position> plist = map.get(key);
            //Collections.sort(list);
            Collections.sort(plist, new Comparator<Position>() {
                @Override
                public int compare(Position o1, Position o2) {
                    if (o1.y > o2.y) return 1;
                    if (o1.y == o2.y) return o1.val > o2.val ? 1 : -1;
                    return -1;
                }
            });
            List<Integer> list = plist.stream().map(position -> position.val).collect(Collectors.toList());
            res.add(list);
        }

        return res;
    }

    private void dfs(Map<Integer, List<Position>> map, TreeNode node, int x, int y) {
        Position p = new Position(x, y, node.val);
        if(map.get(x) == null) {
            ArrayList<Position> list = new ArrayList<>();
            list.add(p);
            map.put(x, list);
        } else {
            map.get(x).add(p);
        }

        if(node.left != null) dfs(map, node.left, x-1, y-1);
        if(node.right != null) dfs(map, node.right, x+1, y-1);
    }

    class Position {
        int x;
        int y;
        int val;
        Position(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.val = v;
        }
    }
}
