package com.misc.ds;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private EdgeNode[] edges;
    private int edgeCount = 0;
    private boolean isDirected;

    public Graph(int numberNodes, boolean isDirected) {
        this.isDirected = isDirected;
        this.edges = new EdgeNode[numberNodes];
    }

    public static void main(String[] args) {
        Graph g = new Graph(13, false);

        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 12);
        g.addEdge(1, 3, 10);
        g.addEdge(2, 4, 11);
        g.addEdge(2, 5, 13);
        g.addEdge(3, 5, 12);
        g.addEdge(3, 7, 13);
        g.addEdge(4, 6, 9);
        g.addEdge(5, 6, 7);
        g.addEdge(6, 7, 15);
        g.addEdge(8, 9, 12);
        g.addEdge(8, 10, 10);
        g.addEdge(9, 10, 10);
        g.addEdge(10, 11, 9);
        g.addEdge(11, 12, 10);

        g.print();
        
        g.dfs_traversal();
        System.out.println();

        g.bfs_traversal();
        System.out.println();

        System.out.println("number of paths from 0 to 6: " + g.numberOfPaths(0, 1));
    }

    public int numberOfPaths(int u, int v) {
        boolean[] isVisited = new boolean[edges.length];
        return numPaths(u, v, isVisited);
    }

    private int numPaths(int u, int v, boolean[] isVisited) {
        if (u == v) {
            return 1;
        }

        isVisited[u] = true;
        int paths = 0;
        EdgeNode e = edges[u];
        while (e != null) {
            if (!isVisited[e.getV()]) {
                paths += numPaths(e.getV(), v, isVisited);
            }

            e = e.getNext();
        }
        isVisited[u] = false;

        return paths;
    }


    public void bfs_traversal() {
        if (edges.length == 0) return;

        boolean[] isVisited = new boolean[edges.length];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < edges.length; i++) {  // make sure we visit other unreachable nodes from 0
            if (!isVisited[i]) {
                q.add(i);
                isVisited[i] = true;
            }

            while (!q.isEmpty()) {
                int u = q.remove();
                System.out.print(u + " ");

                EdgeNode e = edges[u];
                while (e != null) {
                    int v = e.getV();

                    if (!isVisited[v]) {
                        q.add(v);
                        isVisited[v] = true;
                    }

                    e = e.getNext();
                }
            }
        }
    }

    public void dfs_traversal() {
        if (edges.length == 0) return;

        boolean[] isVisited = new boolean[edges.length];

        for (int i = 0; i < edges.length; i++)
            dfs(i, isVisited);
    }

    private void dfs(int u, boolean[] isVisited) {
        if (isVisited[u]) {
            return;
        }

        System.out.print(u + " ");

        // otherwise mark u visited and visit all the neighbours of u
        isVisited[u] = true;
        EdgeNode e = edges[u];
        while (e != null) {
            dfs(e.getV(), isVisited);
            e = e.getNext();
        }
    }

    public void print() {
        for (int i = 0; i < edges.length; i++) {
            System.out.print(i + " --> ");

            EdgeNode e = edges[i];
            while (e != null) {
                System.out.print(e.getV() + " ");
                e = e.getNext();
            }
            System.out.println();
        }
    }

    public void addEdge(int u, int v, int weight) {
        EdgeNode e = new EdgeNode(v, weight);

        // add e to the list of nodes connected to u
        EdgeNode last = edges[u];
        // add e to front for efficiency
        e.setNext(last);
        edges[u] = e;

        if (!isDirected) {
            EdgeNode e2 = new EdgeNode(u, weight);
            e2.setNext(edges[v]);

            edges[v] = e2;
        }

        edgeCount++;
    }
}

class EdgeNode {
    private int v;
    private int weight;
    private EdgeNode next;

    EdgeNode(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }
}

