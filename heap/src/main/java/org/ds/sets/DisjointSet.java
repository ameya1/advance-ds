package org.ds.sets;

import java.util.HashMap;
import java.util.Map;

public interface DisjointSet {
    void makeSet(Integer data);
    boolean union(int source, int destination);
    DisjointNode findParent(DisjointNode node);

    void display();

}
