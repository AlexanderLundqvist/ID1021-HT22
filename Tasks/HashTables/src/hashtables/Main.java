package hashtables;

import java.io.*;
import java.util.*;

public class Main {
    
    public static long benchmarkLinearString(int iterations, String areaCode) {
        Zip zip = new Zip();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.linearSearch(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static long benchmarkBinaryString(int iterations, String areaCode) {
        Zip zip = new Zip();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.binarySearch(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static long benchmarkLinearInteger(int iterations, Integer areaCode) {
        Zip zip = new Zip();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.linearSearchInt(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static long benchmarkBinaryInteger(int iterations, Integer areaCode) {
        Zip zip = new Zip();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.binarySearchInt(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static long benchmarkLookup(int iterations, Integer areaCode) {
        ZipKeyArray zip = new ZipKeyArray();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.lookup(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static long benchmarkBinaryKey(int iterations, Integer areaCode) {
        ZipKeyArray zip = new ZipKeyArray();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.binarySearch(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static void benchmarkCollisions() {
        SimpleHashTable test_1 = new SimpleHashTable(27773);
        test_1.collisions(27773);
        test_1.collisions(28627);
        test_1.collisions(31327);
        
        SimpleHashTable test_2 = new SimpleHashTable(28627);
        test_2.collisions(27773);
        test_2.collisions(28627);
        test_2.collisions(31327);
        
        SimpleHashTable test_3 = new SimpleHashTable(31327);
        test_3.collisions(27773);
        test_3.collisions(28627);
        test_3.collisions(31327);
        
        
        SimpleHashTable test_4 = new SimpleHashTable(10000);        
        test_4.collisions(10000);
        
        SimpleHashTable test_5 = new SimpleHashTable(20000);        
        test_5.collisions(20000);
        
        SimpleHashTable test_6 = new SimpleHashTable(12345);        
        test_6.collisions(12345);
        
    }
    
    public static long benchmarkSimpleHashLookup(int iterations, int mod, Integer areaCode) {
        SimpleHashTable hashTable = new SimpleHashTable(mod);
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            hashTable.lookup(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }

    
    /*
    How many element you need to look at before finding the one that you're 
    looking for. Try with an increasing size of the array and compare the 
    results with the original solution.
    */
    public static void benchmarkBuckets() {
        HashTable test_1 = new HashTable(10000);
        HashTable test_2 = new HashTable(20000);
        HashTable test_3 = new HashTable(30000);
        HashTable test_4 = new HashTable(12345);
        
        test_1.lookup(10000);
        test_2.lookup(20000);
        test_3.lookup(30000);
        test_4.lookup(12345);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iterations  = 1000; 
        
        // Task 1: Zip
        benchmarkLinearString(iterations, "111 15");
        System.out.println("Linear search string(111 15): " + benchmarkLinearString(iterations, "111 15"));
        System.out.println("Linear search string(984 99): " + benchmarkLinearString(iterations, "984 99"));
        
        benchmarkBinaryString(iterations, "111 15");
        System.out.println("Binary search string(111 15): " + benchmarkBinaryString(iterations, "111 15"));
        System.out.println("Binary search string(984 99): " + benchmarkBinaryString(iterations, "984 99"));
        
        benchmarkLinearInteger(iterations, 11115);
        System.out.println("Linear search integer(111 15): " + benchmarkLinearInteger(iterations, 11115));
        System.out.println("Linear search integer(984 99): " + benchmarkLinearInteger(iterations, 98499));
        
        benchmarkBinaryInteger(iterations, 11115);
        System.out.println("Binary search integer(111 15): " + benchmarkBinaryInteger(iterations, 11115));
        System.out.println("Binary search integer(984 99): " + benchmarkBinaryInteger(iterations, 98499));
        
        
        // Task 2: Zip improved
        benchmarkLookup(iterations, 11115);
        System.out.println("Lookup key(111 15): " + benchmarkLookup(iterations, 11115));
        System.out.println("Lookup key(984 99): " + benchmarkLookup(iterations, 98499));
        
        //System.out.println("Binary search key(111 15): " + benchmarkBinaryKey(iterations, 11115));
        //System.out.println("Binary search key(984 99): " + benchmarkBinaryKey(iterations, 98499));
        
        
        // Task 3: Simple hash table
        /*
        27773
        28627
        31327
        */
        //benchmarkCollisions();
        //benchmarkSimpleHashLookup(iterations, 10000, 11115);
        //benchmarkSimpleHashLookup(iterations, 10000, 98499);
        
        // Task 4: Complete hash table with separate chaining
        //benchmarkBuckets();
        
        
    }

}
