package com.xiaode.MediumSolutions;

import com.sun.tools.hat.internal.util.Comparer;

import java.util.*;

/**
 * Created by liyangde on Nov, 2018
 *
 * 332. Reconstruct Itinerary
 *
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 *
 */
public class ReconstructItinerary {
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, Node> airports = new HashMap<>();

        for (String[] ticket : tickets) {
            Node from = airports.get(ticket[0]);
            Node to = airports.get(ticket[1]);
            if (to == null) {
                to = new Node(ticket[1]);
                airports.put(ticket[1], to);
            }

            if (from == null) {
                from =  new Node(ticket[0]);
                airports.put(ticket[0], from);
            }

            from.next.add(to);
        }
        visit("JFK", airports);
        return res;
    }

    void visit(String airport, Map<String, Node> targets) {
        while(targets.containsKey(airport) && !targets.get(airport).next.isEmpty())
            visit(targets.get(airport).next.poll().name, targets);
        res.add(0, airport);
    }
    class Node{
        String name;
        PriorityQueue<Node> next;
        Node(String name){
            this.name = name;
            next = new PriorityQueue<>(Comparator.comparing(Node::getName));
        }

        public String getName() {
            return name;
        }
    }
}
