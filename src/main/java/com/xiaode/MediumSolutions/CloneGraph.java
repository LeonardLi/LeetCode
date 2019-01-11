package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Jan, 2019
 *
 * 133. Clone Graph
 *
 * Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in its neighbors.
 *
 *
 * OJ's undirected graph serialization (so you can understand error output):
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 *
 *
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 *
 *
 * Visually, the graph looks like the following:
 *
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 * Note: The information about the tree serialization is only meant so that you can understand error output if you get a wrong answer. You don't need to understand the serialization to solve the problem.
 */
public class CloneGraph {

    //BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

        if (node == null) return node;
        map.put(node, new UndirectedGraphNode(node.label));
        q.add(node);

        while (!q.isEmpty()) {
            UndirectedGraphNode u = q.poll();

            UndirectedGraphNode cloneNodeU = map.get(u);
            if (u.neighbors != null) {
                List<UndirectedGraphNode> n = u.neighbors;
                for (UndirectedGraphNode uNode : n) {
                    UndirectedGraphNode cloneNodeG = map.get(uNode);
                    if (cloneNodeG == null) {
                        q.add(uNode);
                        cloneNodeG = new UndirectedGraphNode(uNode.label);
                        map.put(uNode, cloneNodeG);
                    }
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }
        return map.get(node);
    }


    //DFS
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}

class UndirectedGraphNode {
  int label;
  List<UndirectedGraphNode> neighbors;
  UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}