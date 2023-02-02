package org.ds.heap;

import java.util.ArrayList;
import java.util.List;

public class NumberBinaryHeap<T extends Number> implements GenericBinaryHeap<T>{

    // https://stackoverflow.com/questions/2683202/comparing-the-values-of-two-generic-numbers

    private List<T> heap;

    public NumberBinaryHeap() {
        this(16);
    }

    public NumberBinaryHeap(int capacity) {
        this.heap = new ArrayList<>(capacity);
    }

    @Override
    public void insert(T n) {

    }

    @Override
    public void peek(T n) {

    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public List<T> heap() {
        return null;
    }

    @Override
    public void update(T newValue) {

    }

    @Override
    public void display() {

    }

    private T heapValue(int index) {
        return null;
    }

    private boolean inLongBounds(double value) {
        int maxCheck = Double.compare(value, Long.MAX_VALUE);
        int minCheck = Double.compare(value, Long.MIN_VALUE);
        return maxCheck <= 0 && minCheck >= 0;
    }

    private void bubbleUp(int childIndex) {
        /*while(true) {
            int parentIndex = (childIndex - 1) / 2;
            if(heapValue(parentIndex) < heapValue(childIndex)) {
                int temp = heapValue(parentIndex);
                heap.set(parentIndex, heapValue(childIndex));
                heap.set(childIndex, temp);
            } else break;
            childIndex = parentIndex;
        }*/
    }
}
