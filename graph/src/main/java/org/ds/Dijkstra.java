package org.ds;

import org.ds.heap.BinHeap;
import org.graph.Node;
/*
*
* djikstras
- graph containing nodes with distance
- binary min heap + map ds for storing nodes with distances
- distance map
- parent map
* */
public class Dijkstra {
    public static void main(String[] args) {
        BinHeap<Node<String>> heap = new BinHeap<>();
        heap.extract();
        heap.insert(new Node<>("A", 10));
        heap.extract();
        heap.insert(new Node<>("B", 1));
        heap.insert(new Node<>("C", 90));
        heap.insert(new Node<>("D", 11));
        heap.insert(new Node<>("E", 8));
        heap.insert(new Node<>("F", 5));
        heap.insert(new Node<>("G", 3));
        heap.insert(new Node<>("H", 56));
        heap.display();
        heap.decrease(new Node<>("A", 46));
        heap.display();

        while (!heap.isEmpty()) {
            System.out.println(heap.extract());
        }
    }
}
