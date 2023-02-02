package org.ds.heap;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Task {

    static {
        counter = new AtomicLong(0);
    }
    static AtomicLong counter;
    long id;
    String name;
    int weight;
    int index;

    public Task(String name, int weight) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && weight == task.weight && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", index=" + index +
                '}';
    }
}
