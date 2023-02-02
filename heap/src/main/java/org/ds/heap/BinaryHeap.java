package org.ds.heap;

import java.util.List;

public interface BinaryHeap {
    void insert(int n);
    void peek(int n);
    int poll();

    default boolean isEmpty() {
        return heap().isEmpty();
    }

    List<Integer> heap();

    void update(int index, int newValue);
    void display();
}
