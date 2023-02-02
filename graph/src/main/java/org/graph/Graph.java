package org.graph;

import java.util.*;

public class Graph<T> {
    Map<T, List<T>> graph;
    boolean bidirectional;

    public Graph() {
        this.graph = new HashMap<>();
        this.bidirectional = true;
    }

    public Graph(boolean bidirectional) {
        this();
        this.bidirectional = false;
    }

    public void add(T src, T dest) {
        connect(src, dest);
        if(bidirectional)
            connect(dest, src);
    }

    private void connect(T src, T dest) {
        List<T> adjList = graph.get(src) != null ?  graph.get(src) : new LinkedList<>();
        adjList.add(dest);
        graph.put(src, adjList);
    }

    public void display() {
        this.graph.forEach((node, adjList) -> System.out.println(node + " -> " + adjList));
    }

    public void bfs() {
        Set<T> visited = new HashSet<>();
        Set<T> nodes = graph.keySet();
        Queue<T> queue = new LinkedList<>();

        for (T node : nodes) {
            queue.add(node);
            while (!queue.isEmpty()) {
                T vertex = queue.poll();

                if(visited.contains(vertex))
                    continue;

                System.out.println("Visiting : " + vertex);
                visited.add(vertex);

                List<T> adjList = graph.get(vertex);
                queue.addAll(adjList);
                System.out.println("Queue : " + queue);
            }
        }
    }

    public void dfs() {
        Set<T> visited = new HashSet<>();
        Set<T> nodes = graph.keySet();
        Stack<T> stack = new Stack<>();
        for (T node : nodes) {
            stack.add(node);
            while (!stack.isEmpty()) {
                T vertex = stack.pop();

                if(visited.contains(vertex))
                    continue;

                System.out.println("Visiting : " + vertex);
                visited.add(vertex);

                List<T> adjList = graph.get(vertex);
                stack.addAll(adjList);
                System.out.println("Stack : " + stack);
            }
        }
    }

    public boolean dfsCycle() {
        Set<T> visited = new HashSet<>();
        Set<T> nodes = graph.keySet();
        Stack<T> stack = new Stack<>();

        for (T node : nodes) {
            stack.push(node);
            while (!stack.isEmpty()) {
                T n = stack.pop();
                if(visited.contains(n)){
                    System.out.println("visited: " + visited);
                    System.out.println("visiting : " + n);
                    return true;
                }

                visited.add(n);
                System.out.println("Visiting : " + n);
                List<T> adjList = graph.get(n);
                stack.addAll(adjList);
                System.out.println("Stack : " + stack);
            }
        }
        return false;
    }

    public void cycleCountAndDisplay() {
        Map<T, T> visited = new HashMap<>();
        Set<T> nodes = graph.keySet();
        Stack<T> stack = new Stack<>();
        int count = 0;
        for (T node : nodes) {
            stack.push(node);
            T parent = null;
            while (!stack.isEmpty()) {
                T n = stack.pop();
                if(visited.containsKey(n) && visited.get(n) != null && !visited.get(n).equals(parent)) {
                    System.out.println(visited);
                    count++;
                    visited.clear();
                    stack.clear();
                    continue;
                }
                visited.put(n, parent);
                System.out.println("Visiting : " + n);
                List<T> adjList = graph.get(n);
                stack.addAll(adjList);
                System.out.println("Stack : " + stack);
                parent = n;
            }
        }
        System.out.println("Cycles " + count);
    }
}
