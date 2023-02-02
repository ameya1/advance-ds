package org.ds.heap;

import java.util.*;

public class TaskBinaryHeap implements GenericBinaryHeap<Task>{

    /**
     * Note: Need to implement task update
     */
    List<Task> heap;
    Map<Task, Integer> index;

    public TaskBinaryHeap() {
        this(16);
    }

    public TaskBinaryHeap(int capacity) {
        this.heap = new ArrayList<>(capacity);
        this.index = new HashMap<>();
    }

    @Override
    public void insert(Task task) {
        addTask(task);
        int childIndex = this.heap.size() - 1;
        bubbleUp(childIndex);
    }

    private void addTask(Task task) {
        this.heap.add(task);
        task.index = this.heap.size() - 1;
    }

    private void bubbleUp(int childIndex){
        while (true) {
            int parentIndex = (childIndex - 1) / 2;
            Task parentTask = task(parentIndex);
            Task childTask = task(childIndex);
            if(parentTask.weight < childTask.weight) {
                heap.set(parentIndex, childTask);
                heap.set(childIndex, parentTask);
                childTask.index = parentIndex;
                parentTask.index = childIndex;
            } else
                break;
            childIndex = parentIndex;
        }
    }

    @Override
    public void peek(Task n) {

    }

    @Override
    public Task poll() {
        Task task = this.heap.get(0);
        int lastIndex = heap.size() - 1;
        Task lastTask = task(lastIndex);
        this.heap.set(0, lastTask);
        this.heap.remove(lastIndex);
        int parentIndex = 0;
        pushDown(parentIndex);
        return task;
    }

    public void pushDown(int parentIndex) {
        while (true) {
            int left = parentIndex * 2 + 1;
            int right = parentIndex * 2 + 2;
            int maxIndex = left;

            if(left >= heap.size())
                break;
            else if(right >= heap.size()){
                maxIndex = left;
            } else {
                maxIndex = task(left).weight > task(right).weight ? left : right;
            }

            Task parentTask = task(parentIndex);
            if (parentTask.weight < task(maxIndex).weight) {
                Task maxTask = task(maxIndex);
                heap.set(parentIndex, maxTask);
                heap.set(maxIndex, parentTask);
            }

            parentIndex = maxIndex;
        }
    }

    @Override
    public List<Task> heap() {
        return Collections.unmodifiableList(heap);
    }

    private Task task(int index) {
        return this.heap.get(index);
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void display() {
        this.heap.forEach(task -> System.out.println(task));
    }
}
