package org.graph;

import java.util.Objects;

public class Node<T> implements Comparable<Node<T>>{
    T data;
    boolean visited;
    int distance;
    int heuristicDistance;

    public Node(T data) {
        this.data = data;
        this.visited = false;
        this.heuristicDistance = 0;
    }

    public Node(T data, int distance) {
        this(data);
        this.distance = distance;
    }

    @Override
    public String toString() {
        return data.toString() + "|" + distance;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.distance - o.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
