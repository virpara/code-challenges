package com.misc.ds;

public class Graph {
    private EdgeNode[] edges;
    private int edgeCount = 0;
    private boolean isDirected;

    public Graph(int numberNodes, boolean isDirected) {
        this.isDirected = isDirected;
        this.edges = new EdgeNode[numberNodes];
    }

    public static void main(String[] args) {
        Graph g = new Graph(6, false);

        g.addEdge(2, 4, 1);
        g.addEdge(2, 5, 1);

        g.print();

    }

    private void print() {
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

