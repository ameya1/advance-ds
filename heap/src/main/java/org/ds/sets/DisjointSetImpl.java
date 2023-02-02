package org.ds.sets;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetImpl implements DisjointSet {

    /**
     *
     * Important steps
     * 1. Make set
     * 2. Union
     * 3. Find Parent
     *
     */

    Map<Integer, DisjointNode> nodes;

    public DisjointSetImpl() {
        this.nodes = new HashMap<>();
    }

    /**
     * Creates a new disjoint node with data and adding it into the nodes map
     *
     * @param data
     */
    @Override
    public void makeSet(Integer data) {
        this.nodes.put(data, new DisjointNode(data));
    }

    /**
     * Unions two nodes creating a parent child relationship
     * 1. Gets the two nodes from the map
     * 2. Gets the parents of the two nodes
     * 3. if parents are same return false
     * 4. For the parent with higher or equal rank
     *      i. Assign it as a parent to another node
     *      ii. increment it's rank by 1
     *      iii. return true
     *
     * @param source
     * @param destination
     * @return
     */

    @Override
    public boolean union(int source, int destination) {
        DisjointNode sourceNode = this.nodes.get(source);
        DisjointNode destinationNode = this.nodes.get(destination);

        DisjointNode sourceNodeParent = findParent(sourceNode);
        DisjointNode destinationNodeParent = findParent(destinationNode);

        if(sourceNodeParent == destinationNodeParent)
            return false;

        if(sourceNodeParent.rank >= destinationNodeParent.rank) {
            sourceNodeParent.rank = sourceNodeParent.rank > destinationNodeParent.rank ? sourceNodeParent.rank : sourceNodeParent.rank + 1;
            destinationNodeParent.parent = sourceNodeParent;
        } else {
            sourceNodeParent.parent = destinationNodeParent;
        }

        return true;
    }

    /**
     * Recursively finding the parent of the node
     *
     * @param node
     * @return
     */
    @Override
    public DisjointNode findParent(DisjointNode node) {
        if(node.parent == node)
            return node.parent;
        return findParent(node.parent);
    }

    public void display() {
        this.nodes.forEach((data, node) -> System.out.println(data + " " + node));
        System.out.println();
    }
}
