package com.util;

import java.util.LinkedList;
import java.util.List;

public class GraphEdgeList {
    private List<EdgeToNode>[] edgeList;
    private boolean isDirected;

    public GraphEdgeList(int numOfNodes, boolean isDirected) {
        edgeList = new List[numOfNodes];
        this.isDirected = isDirected;
    }

    public static void main(String[] args) throws Exception {
        TakeInputBufferedReader in = new TakeInputBufferedReader();
        int n = in.getInt();

        GraphEdgeList g = new GraphEdgeList(n, false);

        while (n-- > 0) {
            Integer[] ia = in.getInts();
            g.addEdge(ia[0], ia[1], ia[2]);
        }

        System.out.println();
    }

    public void addEdge(int u, int v, int weight) {
        if (edgeList[u] == null)
            edgeList[u] = new LinkedList<>();

        edgeList[u].add(new EdgeToNode(v, weight));

        if (!isDirected) { // undirected graph
            if (edgeList[v] == null)
                edgeList[v] = new LinkedList<>();

            edgeList[v].add(new EdgeToNode(u, weight));
        }
    }

    private static class EdgeToNode {
        private int v;
        private int weight;

        private EdgeToNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }
}
