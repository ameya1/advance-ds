package org.ds.bloom;

import java.util.*;
import java.util.stream.IntStream;

/**
 * References:
 *  https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/
 *  
 *
 */

public class BloomFilter {
    public static void main(String[] args) {
        int arrLen = 100000000;
        int fillSize = 10000000;
        //Set<String> nums = new HashSet<>();
        List<Boolean> bloom = new ArrayList<>(arrLen);
        for(int i = 0; i < arrLen; i++)
            bloom.add(false);
        for(int i = 0; i < fillSize; i++) {
            String s = UUID.randomUUID().toString();
            /*String hash = h1 + " " + h2 + " " + h3 + " " + h4;
            if(nums.contains(hash))
                System.out.println("contains " + hash);
            else nums.add(hash);*/
            add(s, arrLen, bloom);
        }
        String a = "jack";
        String b = "powder";
        String c = "beautiful";
        String d = "sad";

       // add(a, arrLen, bloom);
        //add(b, arrLen, bloom);
        System.out.println(a + probablyContains(a, arrLen, bloom));
        System.out.println(b + probablyContains(b, arrLen, bloom));
        System.out.println(c + probablyContains(c, arrLen, bloom));
        System.out.println(d + probablyContains(d, arrLen, bloom));


    }

    public static void add(String s, int arrLen, List<Boolean> bloom) {
        int h1 = h1(s, arrLen);
        int h2 = h2(s, arrLen);
        int h3 = h3(s, arrLen);
        int h4 = h4(s, arrLen);
        bloom.set(h1, true);
        bloom.set(h2, true);
        bloom.set(h3, true);
        bloom.set(h4, true);
    }

    public static boolean probablyContains(String s, int arrLen, List<Boolean> bloom) {
        int h1 = h1(s, arrLen);
        int h2 = h2(s, arrLen);
        int h3 = h3(s, arrLen);
        int h4 = h4(s, arrLen);
        return bloom.get(h1) && bloom.get(h2) && bloom.get(h3) && bloom.get(h4);
    }

    static int h1(String s, int arrSize) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++)
        {
            hash = (hash + s.charAt(i));
            hash = hash % arrSize;
        }
        return Math.abs(hash);
    }

    // hash 2
    static int h2(String s, int arrSize) {
        int hash = 1;
        for (int i = 0; i < s.length(); i++)
        {
            hash = hash + (int)Math.pow(19, i) * s.charAt(i) ;
            hash = hash % arrSize;
        }
        return Math.abs(hash) % arrSize;
    }

    // hash 3
    static int h3(String s, int arrSize) {
        int hash = 7;
        for (int i = 0; i < s.length(); i++)
        {
            hash = (hash * 31 + s.charAt(i)) % arrSize;
        }
        return Math.abs(hash) % arrSize;
    }

    // hash 4
    static int h4(String s, int arrSize) {
        int hash = 3;
        int p = 7;
        for (int i = 0; i < s.length(); i++) {
            hash += hash * 7 + s.charAt(i) * Math.pow(p, i);
            hash = hash % arrSize;
        }
        return Math.abs(hash);
    }

}
