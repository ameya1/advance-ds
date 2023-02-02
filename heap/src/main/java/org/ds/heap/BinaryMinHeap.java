package org.ds.heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap {

    List<Integer> heap;
    Map<Integer, Integer> valueIndexMap;

    public BinaryMinHeap() {
        this.heap = new LinkedList<>();
        this.valueIndexMap = new HashMap<>();
    }

    public void insert(int value) {
        heap.add(value);
        int childIndex = heap.size() - 1;
        valueIndexMap.put(value, childIndex);
        bubbleUp(childIndex);
    }

    public void bubbleUp(int childIndex) {
        while (true) {
            int parentIndex = parentIndex(childIndex);
            int parentValue = heapValue(parentIndex);
            int childValue = heapValue(childIndex);
            if(parentValue > childValue) {
                heap.set(parentIndex, childValue);
                heap.set(childIndex, parentValue);
                updateIndex(childValue, parentIndex);
                updateIndex(parentValue, childIndex);
            } else
                break;
            childIndex = parentIndex;
        }
    }

    public int parentIndex(int childIndex) {
        return (childIndex - 1)/ 2;
    }

    public int heapValue(int index) {
        return heap.get(index);
    }

    public void updateIndex(int value, int index) {
        valueIndexMap.put(value, index);
    }

    public Integer extract() {
        int top = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heapValue(lastIndex));
        updateIndex(heapValue(0), 0);
        valueIndexMap.remove(top);
        heap.remove(lastIndex);
        pushDown(0);
        return top;
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
                min = heapValue(left) < heapValue(right) ? left : right;

            int parentValue = heapValue(parentIndex);
            int childValue = heapValue(min);
            if(parentValue > childValue) {
                heap.set(parentIndex, childValue);
                heap.set(min, parentValue);
                updateIndex(childValue, parentIndex);
                updateIndex(parentValue, min);
            }
            parentIndex = min;
        }
    }

    public void decrease(int oldValue, int newValue) {
        if(!valueIndexMap.containsKey(oldValue)) {
            System.out.println(oldValue + " : does not exist");
            return;
        }

        int index = updateValueMap(oldValue, newValue);

        //int parentIndex = parentIndex(index);
        //int left = 2 * index + 1;
        //int right = 2 * index + 2;

        //boolean greaterThanLeft = left < heap.size() && heapValue(index) > heapValue(left);
        //boolean greaterThanRight = right < heap.size() && heapValue(index) > heapValue(right);

        //if(heapValue(parentIndex) > heapValue(index))
            bubbleUp(index);
        //else if(greaterThanLeft || greaterThanRight)
            pushDown(index);
    }

    public int updateValueMap(int oldValue, int newValue) {
        int index = valueIndexMap.get(oldValue);
        heap.set(index, newValue);
        valueIndexMap.remove(oldValue);
        valueIndexMap.put(newValue, index);
        return index;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("heap is empty");
            return;
        }
        heap.forEach(num -> System.out.print(num + " "));
        System.out.println();
        valueIndexMap.forEach((num, index) -> System.out.println(num + " : " + index));
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        BinaryMinHeap heap = new BinaryMinHeap();
        heap.insert(10);
        //heap.extract();
        heap.insert(5);
        heap.insert(1);
        heap.insert(6);
        heap.insert(20);
        heap.insert(16);
        heap.insert(40);
        heap.insert(80);
        heap.display();
        heap.decrease(10, 22);
        heap.display();
        while(!heap.isEmpty()) {
            System.out.print(heap.extract() + " ");
        }
        heap.display();
    }
}
