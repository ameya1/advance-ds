package org.ds.sets;

import java.util.Objects;

public class DisjointNode {
    int rank;
    int data;
    DisjointNode parent;

    public DisjointNode(int data) {
        this.rank = 0;
        this.data = data;
        this.parent = this;
    }

    @Override
    public String toString() {
        return "DisjointNode{" +
                "rank=" + rank +
                ", data=" + data +
                ", parent=" + parent.data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisjointNode that = (DisjointNode) o;
        return data == that.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
