package org.ds.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerBinaryHeap implements BinaryHeap {

    /**
     * Note: Load test to be done
     */

    private List<Integer> heap;

    public IntegerBinaryHeap() {
        this(16);
    }

    public IntegerBinaryHeap(int capacity) {
        this.heap = new ArrayList<>(capacity);
    }

    /*@Override
    public void insert(int n) {
        heap.add(n);
        int childIndex = heap.size() - 1;
        while(true) {
            int parentIndex = (childIndex - 1) / 2;
            if(heapValue(parentIndex) < heapValue(childIndex)) {
                int temp = heapValue(parentIndex);
                heap.set(parentIndex, heapValue(childIndex));
                heap.set(childIndex, temp);
            } else break;
            childIndex = parentIndex;
        }
    }*/

    /**
     *  Follows bottom-up approach
     * 1. insert elements at the end
     * 2. compare it with its parent -> ( i - 1 ) / 2
     * 3. replace if child is greater to parent -> max heap or replace if child is smaller than parent -> min heap
     * 4. loop till parent is greater
     * 5. assign parent index to child
     *
     * */
    public void insert(int n) {
        heap.add(n);
        int childIndex = heap.size() - 1;
        bubbleUp(childIndex);
    }

    private int heapValue(int index) {
        return heap.get(index);
    }

    @Override
    public void peek(int n) {

    }

    /**
     *
     *      Follows top-down approach
     * 1. Store first value in temp;
     * 2. Replace first value with last value in the heap array
     * 3. Store first index as parent index
     * 4. Loop till true
     * 5. Get the left index -> parent index * 2 + 1
     * 6. Get the right index -> parent index * 2 + 2
     * 7. Determine the index with max value between left and right
     * 8. If left index is greater than heap size then break loop
     * 9. If right index is greater than the heap size consider left index to have max value
     * 10. compare the values of the left and right index and get the index with the max value
     * 11. compare the values of the parent index and max index and swap the values
     * 12. return the top value
     *
    * */
    @Override
    public int poll() {
        int firstIndex = 0;
        int firstValue = heapValue(firstIndex);

        int lastIndex = heap.size() - 1;
        int lastValue = heapValue(lastIndex);
        heap.set(firstIndex, lastValue);
        heap.remove(lastIndex);
        pushDown(0);
        return firstValue;
    }

    @Override
    public void update(int index, int value) {
        heap.set(index, value);

        int parentIndex = ( index + 1 ) / 2;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;

        if(heapValue(parentIndex) < heapValue(index)) {
            bubbleUp(index);
        } else if(heapValue(index) < heapValue(leftIndex) || heapValue(index) < heapValue(rightIndex)){
            pushDown(index);
        }
    }

    private void
    bubbleUp(int childIndex) {
        while(true) {
            int parentIndex = (childIndex - 1) / 2;
            if(heapValue(parentIndex) < heapValue(childIndex)) {
                int temp = heapValue(parentIndex);
                heap.set(parentIndex, heapValue(childIndex));
                heap.set(childIndex, temp);
            } else break;
            childIndex = parentIndex;
        }
    }

    private void pushDown(int parentIndex) {
        while (true) {
            int leftIndex = 2 * parentIndex + 1;
            int rightIndex = 2 * parentIndex + 2;
            int maxIndex = parentIndex;

            if(leftIndex >= heap.size())
                break;
            if(rightIndex >= heap.size())
                maxIndex = leftIndex;
            else
                maxIndex = heapValue(leftIndex) > heapValue(rightIndex) ? leftIndex : rightIndex;

            if(heapValue(parentIndex) < heapValue(maxIndex)) {
                int temp = heapValue(parentIndex);
                heap.set(parentIndex, heapValue(maxIndex));
                heap.set(maxIndex, temp);
            } else
                break;
            parentIndex = maxIndex;
        }
    }

    public List<Integer> heap() {
        return Collections.unmodifiableList(heap);
    }

    public void display() {
        System.out.println(heap);
    }
}
