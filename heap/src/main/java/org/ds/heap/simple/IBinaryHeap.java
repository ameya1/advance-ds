package org.ds.heap.simple;


/**
 *  @Interface
 *  Binary heap containing primary functions
 *
 */
public interface IBinaryHeap {
    void insert(int data);
    int extract();
    void delete(int data);
    void decrease(int oldData, int newData);
}
