package org.ds.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Frequency {
    public static void main(String[] args) {
        int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        frequency(arr, 4);
    }

    public static void frequency(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if(!map.containsKey(i))
                map.computeIfAbsent(i, key -> 1);
            else
                map.computeIfPresent(i, (key, value) -> value + 1);
        }
        System.out.println(map);
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> compare(a, b));
        map.entrySet().stream().forEach(entry -> queue.add(entry));
        for (int i = 0; i < k; i++)
            System.out.println(queue.poll());
    }

    public static int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
        return a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) : Integer.compare(b.getValue(), a.getValue());
    }
}
