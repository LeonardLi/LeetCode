package com.xiaode.ADT;

import java.util.Iterator;
import java.util.List;

/**
 * Created by liyangde on Dec, 2018
 */
public class UnionFind {
    Node [] nodes;
    private class Node{
        int parent;
        int rank;
        int data;
        Node(int p){
            parent = p;
            rank = 0;
            data = p;
        }
    }

    public UnionFind(int n){
        nodes = new Node[n+1];
        for (int e = 0 ; e <= n; e++) {
            nodes[e] = new Node(e);
        }
    }

    public int find(int e){
        if (nodes[e].parent == e) return e;
        return find(nodes[e].parent);
    }

    public void union(int a , int b) {
        a = find(a);
        b = find(b);
        if (nodes[a].rank > nodes[b].rank)
            nodes[b].parent = a;
        else {
            nodes[a].parent = b;
            if (nodes[a].rank == nodes[b].rank) nodes[b].rank++;
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(30);
        uf.union(1,2);
        uf.union(1,3);
        uf.union(2,4);
        uf.union(5,6);
        uf.union(5,7);
        uf.union(6,8);
        uf.union(7,9);
        uf.union(10, 11);

        if (uf.find(4) == uf.find(6)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        if (uf.find(5) == uf.find(9)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

}

//UnionFind with path compression
class UnionFind2 {
    private int[] father;
    private int count;
    public UnionFind2(int n) {
        father = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public int count() {
        return this.count;
    }

    public int find(int p) {
        int root = father[p];
        while (root != father[root])
            root = father[root];
        //compress the path
        while (p != root) {
            int tmp = father[p];
            father[p] = root;
            p = tmp;
        }
        return root;
    }

    public void union(int p, int q) {
        int fatherP = find(p);
        int fatherQ = find(q);
        if (fatherP != fatherQ) {
            father[fatherP] = fatherQ;
            count--;
        }
    }
}
