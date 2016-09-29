package com.github.jinsen47;

import com.github.jinsen47.model.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Jinsen on 16/9/21.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return null;
    }

    public void BFS(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> traveledSet = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            System.out.println(curNode.label);
            traveledSet.add(curNode);
            for (UndirectedGraphNode n : curNode.neighbors) {
                if (!traveledSet.contains(n)) {
                    queue.add(n);
                    traveledSet.add(n);
                }
            }
        }
    }

    public void DFS(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> travaledSet = new HashSet<>();
        dfsCore(node, travaledSet);
    }

    private void dfsCore(UndirectedGraphNode node, Set<UndirectedGraphNode> traveledSet) {
        if (!traveledSet.contains(node)) {
            System.out.println(node.label);
            traveledSet.add(node);
            if (!node.neighbors.isEmpty()) {
                for (UndirectedGraphNode n : node.neighbors) {
                    dfsCore(n, traveledSet);
                }
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node1.neighbors.add(node0);
        node2.neighbors.add(node2);
        node2.neighbors.add(node0);

        CloneGraph cloneGraph = new CloneGraph();
//        cloneGraph.cloneGraph(node0);
        cloneGraph.BFS(node2);
//        cloneGraph.DFS(node0);
    }
}
