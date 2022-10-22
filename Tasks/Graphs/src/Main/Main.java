package Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * This class controls the program flow and is responsible for the various 
 * benchmarks for other functions/methods in other classes.
 *
 * @author Alexander Lundqvist
 * Created: 30.09.2022
 */
public class Main {
    
    private static String[] unsortedLetterArray(int n) {
        Random rand = new Random();
        String[] array = new String[n];
        for (int i = 0; i < n ; i++) {
            array[i] = rand.nextInt(n*10);
        }
        return array;
    }
    
    private static Integer[] unsortedIntegerArray(int n) {
        Random rand = new Random();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n ; i++) {
            array[i] = rand.nextInt(n*10);
        }
        return array;
    }
    
    /**
     * Template for other benchmark methods
     */
    public static void benchmarkEnqueueV1(int initialSize, int rounds, int iterations) {
        // Fix runtime compilation interference
//        ListHeapV1 pre = new ListHeapV1();
//        pre.enqueue(1);
//        pre.dequeue();
//        pre = null;
//        
//        Random rand = new Random();
//        int size = initialSize;
//        for (int i = 0; i < rounds; i++) {
//            //System.out.println("Round " + i + " started.");
//            long t_total = 0;
//            long min = Long.MAX_VALUE;
//            long max = 0;
//            for(int j = 0; j < iterations; j++) {
//                //System.out.println("Iteration " + j + " started.");
//                ListHeapV1 heap = new ListHeapV1();
//                int index;
//                // Populate queue
//                for (index = 0; index < size - 1; index++) {
//                    heap.enqueue(rand.nextInt(size*10));   
//                }
//                // Check last enqueue to get O(size)
//                long t_start = System.nanoTime();
//                heap.enqueue(rand.nextInt(size*10));
//                long t_stop = System.nanoTime() - t_start;
//                t_total += t_stop;
//                if (t_stop < min) {
//                    min = t_stop;
//                }
//                if (t_stop > max) {
//                    max = t_stop;
//                }
//                heap = null; // Clean up memory
//            }
//            System.out.println(t_total/iterations);
//            //System.out.println(min);
//            size += initialSize;
//        }
//        System.out.println();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int initialSize = 100;
        int rounds = 100;
        int iterations  = 10;
        String file = "trains.csv";
        
    
    }

}
