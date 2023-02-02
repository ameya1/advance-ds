package org.ds;

import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == -1)
                continue;

            if(arr[i] == i)
                continue;

            if(arr[i] != i) {
                //int temp = 0;
                while (arr[i] != i && arr[i] != -1) {
                    int temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }
}
