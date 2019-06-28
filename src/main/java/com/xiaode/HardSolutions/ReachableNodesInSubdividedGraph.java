package com.xiaode.HardSolutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by liyangde on Jun, 2019
 *
 * 882. Reachable Nodes In Subdivided Graph
 *
 * Starting with an undirected graph (the "original graph") with nodes from 0 to N-1, subdivisions are made to some of the edges.
 *
 * The graph is given as follows: edges[k] is a list of integer pairs (i, j, n) such that (i, j) is an edge of the original graph,
 *
 * and n is the total number of new nodes on that edge.
 *
 * Then, the edge (i, j) is deleted from the original graph, n new nodes (x_1, x_2, ..., x_n) are added to the original graph,
 *
 * and n+1 new edges (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) are added to the original graph.
 *
 * Now, you start at node 0 from the original graph, and in each move, you travel along one edge.
 *
 * Return how many nodes you can reach in at most M moves.
 */
public class ReachableNodesInSubdividedGraph {
    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], -1);
        }

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        int result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a [1]));
        boolean[] visited = new boolean[N];

        pq.offer(new int[]{0, M});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int start = cur[0];
            int move = cur[1];
            if(visited[start]) {
                continue;
            }
            visited[start] = true;
            result++;
            for (int i = 0; i < N; i++) {
                if (graph[start][i] > -1) {
                    if (move > graph[start][i] && !visited[i]) {
                        pq.offer(new int[]{i, move - graph[start][i] - 1});
                    }
                }
                graph[i][start] -= Math.min(move, graph[start][i]);
                result += Math.min(move, graph[start][i]);
            }
        }
        return result;
    }
}
