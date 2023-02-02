package org.ds.heap;

import java.util.List;

public interface GenericBinaryHeap<T> {
    void insert(T n);
    void peek(T n);
    T poll();
    List<T> heap();
    void update(T newValue);
    void display();

    default boolean isEmpty() {
        return heap().isEmpty();
    }
}
