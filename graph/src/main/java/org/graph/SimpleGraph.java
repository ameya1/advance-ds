package org.graph;

import java.util.*;

public class SimpleGraph {

    Map<Integer, List<Integer>> graph;
    boolean bidirectional;

    public SimpleGraph() {
        this.graph = new HashMap<>();
        this.bidirectional = true;
    }

    public SimpleGraph(boolean bidirectional) {
        this();
        this.bidirectional = false;
    }

    public void add(int src, int dest) {
        connect(src, dest);
        if(bidirectional)
            connect(dest, src);
    }

    private void connect(int src, int dest) {
        List<Integer> adjList = graph.get(src) != null ?  graph.get(src) : new LinkedList<>();
        adjList.add(dest);
        graph.put(src, adjList);
    }

    public void display() {
        this.graph.forEach((node, adjList) -> System.out.println(node + " -> " + adjList));
    }

    public void bfs() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> nodes = graph.keySet();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer node : nodes) {
            queue.add(node);
            while (!queue.isEmpty()) {
                Integer vertex = queue.poll();
                System.out.println("Visiting : " + vertex);
                if(visited.contains(vertex))
                    continue;
                visited.add(vertex);
                List<Integer> adjList = graph.get(vertex);
                queue.addAll(adjList);
            }
        }
    }
}
