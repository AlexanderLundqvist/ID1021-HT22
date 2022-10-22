package priorityqueues;

import java.util.*;

public class Main {
    
    // O(1)
    public static void benchmarkEnqueueV1(int initialSize, int rounds, int iterations) {
        // Fix runtime compilation interference
        ListHeapV1 pre = new ListHeapV1();
        pre.enqueue(1);
        pre.dequeue();
        pre = null;
        
        Random rand = new Random();
        int size = initialSize;
        for (int i = 0; i < rounds; i++) {
            //System.out.println("Round " + i + " started.");
            long t_total = 0;
            long min = Long.MAX_VALUE;
            long max = 0;
            for(int j = 0; j < iterations; j++) {
                //System.out.println("Iteration " + j + " started.");
                ListHeapV1 heap = new ListHeapV1();
                int index;
                // Populate queue
                for (index = 0; index < size - 1; index++) {
                    heap.enqueue(rand.nextInt(size*10));   
                }
                // Check last enqueue to get O(size)
                long t_start = System.nanoTime();
                heap.enqueue(rand.nextInt(size*10));
                long t_stop = System.nanoTime() - t_start;
                t_total += t_stop;
                if (t_stop < min) {
                    min = t_stop;
                }
                if (t_stop > max) {
                    max = t_stop;
                }
                heap = null; // Clean up memory
            }
            System.out.println(t_total/iterations);
            //System.out.println(min);
            size += initialSize;
        }
        System.out.println();
    }
    
    // O(n)
    public static void benchmarkDequeueV1(int initialSize, int rounds, int iterations) {
        // Fix runtime compilation interference
        ListHeapV1 pre = new ListHeapV1();
        pre.enqueue(1);
        pre.dequeue();
        pre = null;
        
        Random rand = new Random();
        int size = initialSize;
        for (int i = 0; i < rounds; i++) {
            long t_total = 0;
            long min = Long.MAX_VALUE;
            long max = 0;
            for (int j = 0; j < iterations; j++) {
                // Initialize new heap
                ListHeapV1 heap = new ListHeapV1();
                // Populate heap
                for (int k = 0; k < size; k++) {
                    heap.enqueue(rand.nextInt(size*10));
                }
                // Measure dequeue for queue with size 
                long t_start = System.nanoTime();
                heap.dequeue();
                long t_stop = System.nanoTime() - t_start;
                t_total += t_stop;
                if (t_stop < min) {
                    min = t_stop;
                }
                if (t_stop > max) {
                    max = t_stop;
                }
                // Clean up memory
                heap = null; 
            }
            //System.out.println(t_total/iterations);
            System.out.println(min);
            size += initialSize;
        }
        System.out.println();
    }
    
    // O(n)
    public static void benchmarkEnqueueV2(int initialSize, int rounds, int iterations) {
        // Fix runtime compilation interference
        ListHeapV2 pre = new ListHeapV2();
        pre.enqueue(1);
        pre.dequeue();
        pre = null;
        
        Random rand = new Random();
        int size = initialSize;
        for (int i = 0; i < rounds; i++) {
            //System.out.println("Round " + i + " started.");
            long t_total = 0;
            long min = Long.MAX_VALUE;
            long max = 0;
            for(int j = 0; j < iterations; j++) {
                //System.out.println("Iteration " + j + " started.");
                ListHeapV2 heap = new ListHeapV2();
                int index;
                // Populate queue
                for (index = 0; index < size - 1; index++) {
                    heap.enqueue(rand.nextInt(size*10));   
                }
                // Check last enqueue to get O(size)
                long t_start = System.nanoTime();
                heap.enqueue(rand.nextInt(size*10));
                long t_stop = System.nanoTime() - t_start;
                t_total += t_stop;
                if (t_stop < min) {
                    min = t_stop;
                }
                if (t_stop > max) {
                    max = t_stop;
                }
                heap = null; // Clean up memory
            }
            System.out.println(t_total/iterations);
            //System.out.println(min);
            size += initialSize;
        }
        System.out.println();
    }
    
    // O(1)
    public static void benchmarkDequeueV2(int initialSize, int rounds, int iterations) {
        // Fix runtime compilation interference
        ListHeapV2 pre = new ListHeapV2();
        pre.enqueue(1);
        pre.dequeue();
        pre = null;
        
        Random rand = new Random();
        int size = initialSize;
        for (int i = 0; i < rounds; i++) {
            long t_total = 0;
            long min = Long.MAX_VALUE;
            long max = 0;
            for (int j = 0; j < iterations; j++) {
                // Initialize new heap
                ListHeapV2 heap = new ListHeapV2();
                // Populate heap
                for (int k = 0; k < size; k++) {
                    heap.enqueue(rand.nextInt(size*10));
                }
                // Measure dequeue for queue with size 
                long t_start = System.nanoTime();
                heap.dequeue();
                long t_stop = System.nanoTime() - t_start;
                t_total += t_stop;
                if (t_stop < min) {
                    min = t_stop;
                }
                if (t_stop > max) {
                    max = t_stop;
                }
                // Clean up memory
                heap = null; 
            }
            //System.out.println(t_total/iterations);
            System.out.println(min);
            size += initialSize;
        }
        System.out.println();
    }
    
    // O(?)
    public static void benchmarkArrayEnqueue(int initialSize, int rounds, int iterations) {
        // Fix runtime compilation interference
        ArrayHeap pre = new ArrayHeap(2);
        pre.enqueue(1);
        pre.dequeue();
        pre = null;
        
        Random rand = new Random();
        int size = initialSize;
        for (int i = 0; i < rounds; i++) {
            //System.out.println("Round " + i + " started.");
            long t_total = 0;
            long min = Long.MAX_VALUE;
            long max = 0;
            for(int j = 0; j < iterations; j++) {
                //System.out.println("Iteration " + j + " started.");
                ArrayHeap heap = new ArrayHeap(size);
                int index;
                // Populate queue
                for (index = 0; index < size - 1; index++) {
                    heap.enqueue(rand.nextInt(size*10));   
                }
                // Check last enqueue to get O(size)
                long t_start = System.nanoTime();
                heap.enqueue(rand.nextInt(size*10));
                long t_stop = System.nanoTime() - t_start;
                t_total += t_stop;
                if (t_stop < min) {
                    min = t_stop;
                }
                if (t_stop > max) {
                    max = t_stop;
                }
                heap = null; // Clean up memory
            }
            //System.out.println(t_total/iterations);
            System.out.println(min);
            size += initialSize;
        }
        System.out.println();
    }
    
    // O(?)
    public static void benchmarkArrayDequeue(int initialSize, int rounds, int iterations) {
        // Fix runtime compilation interference
        ArrayHeap pre = new ArrayHeap(2);
        pre.enqueue(1);
        pre.dequeue();
        pre = null;
        
        Random rand = new Random();
        int size = initialSize;
        for (int i = 0; i < rounds; i++) {
            long t_total = 0;
            long min = Long.MAX_VALUE;
            long max = 0;
            for (int j = 0; j < iterations; j++) {
                // Initialize new heap
                ArrayHeap heap = new ArrayHeap(size);
                // Populate heap
                for (int k = 0; k < size; k++) {
                    heap.enqueue(rand.nextInt(size*10));
                }
                // Measure dequeue for queue with size 
                long t_start = System.nanoTime();
                heap.dequeue();
                long t_stop = System.nanoTime() - t_start;
                t_total += t_stop;
                if (t_stop < min) {
                    min = t_stop;
                }
                if (t_stop > max) {
                    max = t_stop;
                }
                // Clean up memory
                heap = null; 
            }
            //System.out.println(t_total/iterations);
            System.out.println(min);
            size += initialSize;
        }
        System.out.println();
    }
    
    // Statistics, no time complexity
    public static void benchmarkTree() {
        TreeHeap tree = new TreeHeap();
        Random rand = new Random();
        long min = Long.MAX_VALUE;
        long max = 0;
        long t_total = 0;
        for (int i = 0; i < 64; i++) {
            long t_start = System.nanoTime();
            tree.enqueue(rand.nextInt(101));
            long t_stop = System.nanoTime() - t_start;
            t_total += t_stop;
            if (t_stop < min) {
                min = t_stop;
            }
            if (t_stop > max) {
                max = t_stop;
            }
        }
        System.out.println("Enqueue min. time: " + min);
        System.out.println("Enqueue max. time: " + max);
        System.out.println("Enqueue avg. time: " + t_total/64);
        
        int sequence = 20;
        
        for(int j = 0; j < sequence; j++) {
            int value = rand.nextInt(11)+10;
            int depth = tree.push(value);
            System.out.println("Depth " + depth + " for value " + value);
        }
        
        System.out.println();
    }
    
    /**
     * This class runs benchmarks on all priority queues.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int initialSize = 100;
        int rounds = 100;
        int iterations  = 10;
        
//        System.out.println("----------------- ListHeapV1 Enqueue -----------------");
//        benchmarkEnqueueV1(initialSize, rounds, iterations); // O(1)

//        System.out.println("----------------- ListHeapV1 Dequeue -----------------");
//        benchmarkDequeueV1(initialSize, rounds, iterations); // O(n)

//        System.out.println("----------------- ListHeapV2 Enqueue -----------------");
//        benchmarkEnqueueV2(initialSize, rounds, iterations); // O(n)

//        System.out.println("----------------- ListHeapV2 Dequeue -----------------");
//        benchmarkDequeueV2(initialSize, rounds, iterations); // O(1)

        System.out.println("----------------- ArrayHeap Enqueue ------------------");
        benchmarkArrayEnqueue(initialSize, rounds, iterations); // O(?)

//        System.out.println("----------------- ArrayHeap Dequeue ------------------");
//        benchmarkArrayDequeue(initialSize, rounds, iterations); // O(?)

//        System.out.println("----------------- TreeHeap Benchmark -----------------");
//        benchmarkTree();

    }
}
