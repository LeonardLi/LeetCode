package com.xiaode.MediumSolutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liyangde on Feb, 2019
 * <p>
 * 990. Satisfiability of Equality Equations
 */
public class SatisfiabilityofEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        UnionFind u = new UnionFind(26);
        //UnionFind nu = new UnionFind(26);
        Map<Character, Set<Character>> nu = new HashMap<>();

        for (String s : equations) {
            char A = s.charAt(0);
            char B = s.charAt(3);
            char op = s.charAt(1);
            if (op == '!') {
                if (A == B) return false;
                //nu.union(A - 'a', B - 'a');
                Set<Character> setA = nu.getOrDefault(A, new HashSet<>());
                setA.add(B);
                nu.put(A, setA);

                Set<Character> setB = nu.getOrDefault(B, new HashSet<>());
                setB.add(A);
                nu.put(B, setB);
            } else {
                u.union(A - 'a', B - 'a');
            }
        }

        for (String s : equations) {
            char A = s.charAt(0);
            char B = s.charAt(3);
            char op = s.charAt(1);
            if (op == '!') {
                if (u.find(A - 'a') == u.find(B - 'a')) return false;
            } else {
                if (A == B) continue;
                if (nu.containsKey(A) && nu.get(A).contains(B) || nu.containsKey(B) && nu.get(B).contains(A)) return false;
            }
        }

        return true;
    }

    class UnionFind {
        Node[] nodes;

        private class Node {
            int parent;
            int rank;
            int data;

            Node(int p) {
                parent = p;
                rank = 0;
                data = p;
            }
        }

        public UnionFind(int n) {
            nodes = new Node[n + 1];
            for (int e = 0; e <= n; e++) {
                nodes[e] = new Node(e);
            }
        }

        public int find(int e) {
            if (nodes[e].parent == e) return e;
            return find(nodes[e].parent);
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (nodes[a].rank > nodes[b].rank)
                nodes[b].parent = a;
            else {
                nodes[a].parent = b;
                if (nodes[a].rank == nodes[b].rank) nodes[b].rank++;
            }
        }
    }

    public static void main(String[] args) {
        SatisfiabilityofEqualityEquations s = new SatisfiabilityofEqualityEquations();
        System.out.println(s.equationsPossible(new String[]{"a!=i","g==k","k==j","k!=i","c!=e","a!=e","k!=a","a!=g","g!=c"}));
    }
}
