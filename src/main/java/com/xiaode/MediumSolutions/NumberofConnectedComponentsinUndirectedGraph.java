package com.xiaode.MediumSolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liyangde on Nov, 2018
 *
 * 323. Number of Connected Components in an Undirected Graph
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * Output: 2
 * Example 2:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * Output:  1
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class NumberofConnectedComponentsinUndirectedGraph {

    // DFS
    Map<Integer, List<Integer>> graph = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        int [] visited = new int[n];

        for (int i= 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for (int key : graph.keySet()) {
            if (visited[key] == 0){
                res++;
                visit(key, visited);
            }

        }
        return res;

    }

    private void visit(int n , int[] visited) {
        if (visited[n] != 0) return;
        visited[n]++;
        if (graph.get(n).size() != 0)
            for (int i : graph.get(n)){
                if (visited[i] == 0)
                    visit(i, visited);
            }
    }

    //TODO: Union Find

    public static void main(String[] args) {
        NumberofConnectedComponentsinUndirectedGraph n = new NumberofConnectedComponentsinUndirectedGraph();
        n.countComponents(2, new int[][]{
                {1,0}
        });

    }
}
