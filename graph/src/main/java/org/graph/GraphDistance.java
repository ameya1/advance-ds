package org.graph;

import org.ds.heap.BinHeap;

import java.util.*;

public class GraphDistance<T> {
    Map<T, List<Node<T>>> graph;
    boolean bidirectional;
    Map<T, Node<T>> heuristicDistanceMap;

    public GraphDistance() {
        this.graph = new HashMap<>();
        this.bidirectional = true;
        this.heuristicDistanceMap = new HashMap<>();
    }

    public GraphDistance(boolean bidirectional) {
        this();
        this.bidirectional = bidirectional;
    }

    public void connect(T src, T dest, int distance) {
        this.add(src, dest, distance);
        if(bidirectional)
            this.add(dest, src, distance);
    }

    public void add(T src, T dest, int distance) {
        Node<T> node = new Node<>(dest, distance);
        List<Node<T>> adjList = this.graph.containsKey(src) ? this.graph.get(src) : new LinkedList<>();
        adjList.add(node);
        this.graph.put(src, adjList);
    }

    public void display() {
        this.graph.forEach((src, adjList) -> System.out.println(src + " -> " + adjList));
    }

    public void dijkstra(T src) {
        BinHeap<Node<T>> heap = new BinHeap<>();
        Node<T> srcNode = new Node<>(src, 0);
        heap.insert(srcNode);
        Set<Node<T>> visited = new HashSet<>();
        Map<T, T> parentMap = new HashMap<>();
        parentMap.put(srcNode.data, null);
        while (!heap.isEmpty()) {
            Node<T> node = heap.extract();
            visited.add(node);
            List<Node<T>> adjList = this.graph.get(node.data);
            adjList.forEach(adjNode -> {
                adjNode.distance += node.distance;
                if(!visited.contains(adjNode)) {
                    if(heap.decrease(adjNode))
                        parentMap.put(adjNode.data, node.data);
                }
            });
        }
        System.out.println(parentMap);
        System.out.println();
    }

    public void aStar(T src) {
        BinHeap<Node<T>> heap = new BinHeap<>();
        Node<T> srcNode = new Node<>(src, 0);
        heap.insert(srcNode);
        Set<Node<T>> visited = new HashSet<>();
        Map<T, T> parentMap = new HashMap<>();
        parentMap.put(srcNode.data, null);
        while (!heap.isEmpty()) {
            Node<T> node = heap.extract();
            visited.add(node);
            List<Node<T>> adjList = this.graph.get(node.data);
            adjList.forEach(adjNode -> {
                int tempDistance = adjNode.distance;
                adjNode.distance += node.distance + heuristicDistanceMap.get(adjNode.data).distance;
                if(!visited.contains(adjNode)) {
                    if(heap.decrease(adjNode))
                        parentMap.put(adjNode.data, node.data);
                }
                // removing the heuristic distance from the actual distance to avoid not being added to the future nodes
                adjNode.distance = tempDistance + node.distance;
            });
        }
        System.out.println(parentMap);
        System.out.println();
    }

    public void addHeuristicDistance(T src, T destination, int distance) {
        this.heuristicDistanceMap.put(src, new Node<>(destination, distance));
    }
}
