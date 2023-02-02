package org.ds.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * */
public class BinHeap<T extends Comparable<T>> {
    List<T> heap;
    Map<T, Integer> indexMap;

    public BinHeap() {
        this.heap = new ArrayList<>();
        this.indexMap = new HashMap<>();
    }

    public BinHeap(int capacity) {
        this.heap = new ArrayList<>(capacity);
        this.indexMap = new HashMap<>();
    }

    /*public void add(T node) {
        if(indexMap.containsKey(node)) {

        }
    }*/

    public void insert(T node) {
        this.heap.add(node);
        int childIndex = this.heap.size() - 1;
        indexMap.put(node, childIndex);
        bubbleUp(childIndex);
    }

    public void bubbleUp(int childIndex) {
        while (true) {
            int parentIndex = (childIndex - 1) / 2;
            T parentNode = this.heap.get(parentIndex);
            T childNode = this.heap.get(childIndex);
            if(parentNode.compareTo(childNode) > 0) {
                this.heap.set(parentIndex, childNode);
                this.heap.set(childIndex, parentNode);
                this.indexMap.put(childNode, parentIndex);
                this.indexMap.put(parentNode, childIndex);
            } else
                break;
            childIndex = parentIndex;
        }
    }

    public T extract() {
        if(heap.isEmpty())
            return null;

        T top = this.heap.get(0);
        this.indexMap.remove(top);
        this.heap.set(0, heap.get(heapLastIndex()));
        this.heap.remove(heapLastIndex());

        if(!heap.isEmpty()) {
            int parentIndex = 0;
            this.indexMap.put(heap.get(0), 0);
            pushDown(parentIndex);
        }
        return top;
    }

    public int heapLastIndex() {
        return this.heap.size() - 1;
    }

    public void pushDown(int parentIndex) {
        while (true) {
            int left = 2 * parentIndex + 1;
            int right = 2 * parentIndex + 2;
            int min = -1;

            if(left >= heap.size())
                break;
            if(right >= heap.size())
                min = left;
            else
                min = heap.get(left).compareTo(heap.get(right)) < 0 ? left : right;

            if(heap.get(min).compareTo(heap.get(parentIndex)) < 0) {
                T temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(min));
                heap.set(min, temp);
                this.indexMap.put(heap.get(min), parentIndex);
                this.indexMap.put(temp, min);
            }
            parentIndex = min;
        }
    }

    /**
     * Decrease key
     * 1. Get the index for the node from index map
     * 2. update the heap with the new value for the above index
     * 3. update the index map accordingly
     * 4. Get the parent and child indices
     * 5. compare the node at the current index and perform bubble up or push down accordingly
     */
    public boolean decrease(T data) {
        if(!indexMap.containsKey(data)) {
            insert(data);
            return true;
        }
        int index = indexMap.get(data);
        if(heap.get(index).compareTo(data) <= 0) {
            System.out.println("Node exists with shorter distance : old : " + heap.get(index) + " new : " + data);
            return false;
        }

        this.heap.set(index, data);
        this.indexMap.put(data, index);

        int parentIndex = (index - 1) / 2;
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        boolean greaterThanLeft = leftChild < heap.size() && heapValue(index).compareTo(heapValue(leftChild)) > 0;
        boolean greaterThanRight = rightChild < heap.size() && heapValue(index).compareTo(heapValue(rightChild)) > 0;

        if(heap.get(index).compareTo(heap.get(parentIndex)) < 0)
            bubbleUp(index);
        else if(greaterThanLeft || greaterThanRight)
            pushDown(index);
        return true;
    }

    public T heapValue(int index) {
        return heap.get(index);
    }

    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    public void display() {
        this.heap.forEach(node -> System.out.println(node));
        System.out.println();
        this.indexMap.forEach((node, index) -> System.out.println(node + " | " + index));
        System.out.println();
    }

}
