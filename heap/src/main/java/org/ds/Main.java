package org.ds;

import org.ds.heap.*;
import org.ds.sets.DisjointSet;
import org.ds.sets.DisjointSetImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        disjointSets();
    }

    public static void disjointSets() {
        DisjointSet set = new DisjointSetImpl();
        set.makeSet(1);
        set.makeSet(2);
        set.makeSet(3);
        set.makeSet(4);
        set.makeSet(5);
        set.makeSet(6);
        set.makeSet(7);

        set.display();

        set.union(1,2);
        set.union(2,3);
        set.union(4,5);
        set.union(6,7);
        set.union(5,6);
        set.union(3,7);

        set.display();
    }

    public void binaryHeap2() {
        int bound = 1000000000;
        BinaryHeap binaryHeap = new IntegerBinaryHeap(bound);
        Random random = new Random();

        /*random.ints(1, bound)
                .limit(bound)
                .forEach(num -> binaryHeap.insert(num));*/
        //binaryHeap.display();
       /* while (!binaryHeap.isEmpty())
            System.out.println(binaryHeap.poll());*/
        /*binaryHeap.insert(10);
        binaryHeap.insert(45);
        binaryHeap.insert(2);
        binaryHeap.insert(60);
        binaryHeap.insert(89);
        binaryHeap.insert(32);
        binaryHeap.insert(20);
        binaryHeap.insert(1);
        binaryHeap.display();

        binaryHeap.update(3, 70);
        binaryHeap.display();
        binaryHeap.update(2, 10);
        binaryHeap.display();

        while (!binaryHeap.isEmpty())
            System.out.println(binaryHeap.poll());
        binaryHeap.display();*/
    }

    public void binaryHeap() {
        GenericBinaryHeap<Task> taskBinaryHeap = new TaskBinaryHeap();
        System.out.println("\nInserting\n");
        taskBinaryHeap.insert(new Task("A", 10));
        taskBinaryHeap.insert(new Task("b", 70));
        taskBinaryHeap.insert(new Task("c", 80));
        taskBinaryHeap.insert(new Task("d", 40));
        taskBinaryHeap.insert(new Task("e", 90));
        taskBinaryHeap.insert(new Task("f", 100));
        taskBinaryHeap.display();
        System.out.println("\nPolling\n");
        while (!taskBinaryHeap.isEmpty())
            System.out.println(taskBinaryHeap.poll());
        taskBinaryHeap.display();
    }
}