package com.xiaode.MediumSolutions;

import java.util.*;

/**
 * Created by liyangde on Jul, 2019
 *
 * 1129. Shortest Path with Alternating Colors
 *
 * Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and there could be self-edges or parallel edges.
 *
 * Each [i, j] in red_edges denotes a red directed edge from node i to node j.  Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.
 *
 * Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such that the edge colors alternate along the path (or -1 if such a path doesn't exist).
 */
public class ShortestPathwithAlternatingColors {
    class Node{
        int label;
        int rdistance = Integer.MAX_VALUE;
        int bdistance = Integer.MAX_VALUE;
        List<Node> blue;
        List<Node> red;
        Node(int label) {
            this.label = label;
            blue = new ArrayList<>();
            red = new ArrayList<>();
        }

    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Node[] nodes = new Node[n];
        boolean[] bvisited = new boolean[n];
        boolean[] rvisited = new boolean[n];
        bvisited[0] = true;
        rvisited[0] = true;
        for(int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int[] r : red_edges) nodes[r[0]].red.add(nodes[r[1]]);
        for (int[] b : blue_edges) nodes[b[0]].blue.add(nodes[b[1]]);

        Stack<Node> redS = new Stack<>();
        Stack<Node> blueS = new Stack<>();
        Stack<Node> currentRed = new Stack<>();
        Stack<Node> currentBlue = new Stack<>();
        redS.push(nodes[0]);
        blueS.push(nodes[0]);
        nodes[0].rdistance = 0;
        nodes[0].bdistance = 0;
        while(!redS.isEmpty() || !blueS.isEmpty()) {
            while(!redS.isEmpty()){
                Node node = redS.pop();
                for(Node bnode : node.blue) {
                    if(!rvisited[bnode.label]){
                        bnode.rdistance = Math.min(node.bdistance+1, bnode.rdistance);
                        rvisited[bnode.label] = true;
                        currentBlue.push(bnode);
                    }
                }
            }
            while(!blueS.isEmpty()){
                Node node = blueS.pop();
                for(Node rnode : node.red) {
                    if(!bvisited[rnode.label]){
                        rnode.bdistance = Math.min(node.rdistance+1, rnode.bdistance);
                        bvisited[rnode.label] = true;
                        currentRed.push(rnode);
                    }
                }
            }
            blueS = currentBlue;
            redS = currentRed;
            currentBlue = new Stack<>();
            currentRed = new Stack<>();
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            if(nodes[i].rdistance == Integer.MAX_VALUE && nodes[i].bdistance == Integer.MAX_VALUE) res[i] = -1;
            else res[i] = nodes[i].rdistance < nodes[i].bdistance? nodes[i].rdistance : nodes[i].bdistance;
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestPathwithAlternatingColors s = new ShortestPathwithAlternatingColors();
        System.out.println(Arrays.toString(s.shortestAlternatingPaths(5, new int[][]{{0,1},{1,2},{2,3},{3,4}}, new int[][]{{1,2},{2,3},{3,1}})));

    }
}
