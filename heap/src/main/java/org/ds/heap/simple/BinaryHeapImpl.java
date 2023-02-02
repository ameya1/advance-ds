package org.ds.heap.simple;

import java.util.HashMap;
import java.util.Map;

public class BinaryHeapImpl implements IBinaryHeap{

    /**
     * Array to store heap data
     * */
    private int[] heap;

    /**
     *  Map to store the data and its index
     *  key: data
     *  value: heap index
     * */
    private Map<Integer, Integer> dataIndexMap;

    private int capacity;

    public BinaryHeapImpl(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.dataIndexMap = new HashMap<>();
    }

    public BinaryHeapImpl() {
        this(100);
    }

    /**
     *  The data needs to
     *
     *
     * @param data
     *
     */
    @Override
    public void insert(int data) {

    }

    @Override
    public int extract() {
        return 0;
    }

    @Override
    public void delete(int data) {

    }

    @Override
    public void decrease(int oldData, int newData) {

    }
}
