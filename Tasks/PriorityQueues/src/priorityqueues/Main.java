package priorityqueues;

import java.util.*;

public class Main {

    /**
     * This class runs benchmarks on all priority queues.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iterations  = 100;
        Random rnd = new Random();        
        
        // ListHeapV1 enqueue
//        ListHeapV1 v1 = new ListHeapV1();
//        int v1_size = 10;
//        for (int i = 0; i < 20; i++) {
//            long t_total = 0;
//            for (int j = 0; j < iterations; j++) {
//                long t_start = System.nanoTime();
//                v1.enqueue(rnd.nextInt(v1_size*10));
//                t_total += System.nanoTime() - t_start;
//            }
//            System.out.println(t_total/iterations);
//            v1_size += 10;
//        }
//        System.out.println();
        
        // ListHeapV1 dequeue
//        ListHeapV1 v1 = new ListHeapV1();
//        int v1_size = 100;
//        for (int i = 0; i < 20; i++) {
//            // Populate queue
//            for (int j = 0; j < iterations; j++) {
//                v1.enqueue(rnd.nextInt(v1_size*10));
//            }
//            long t_total = 0;
//            for (int j = 0; j < iterations; j++) {
//                long t_start = System.nanoTime();
//                v1.dequeue();
//                t_total += System.nanoTime() - t_start;
//            }
//            System.out.println(t_total/iterations);
//            v1_size += 100;
//        }
//        System.out.println();

        // ListHeapV2 enqueue
//        ListHeapV2 v2 = new ListHeapV2();
//        int v2_size = 100;
//        for (int i = 0; i < 20; i++) {
//            long t_total = 0;
//            for (int j = 0; j < iterations; j++) {
//                long t_start = System.nanoTime();
//                v2.enqueue(rnd.nextInt(v2_size*10));
//                t_total += System.nanoTime() - t_start;
//            }
//            System.out.println(t_total/iterations);
//            v2_size += 100;
//        }
//        System.out.println();
        
        // ListHeapV2 dequeue
//        ListHeapV2 v2 = new ListHeapV2();
//        int v2_size = 100;
//        for (int i = 0; i < 20; i++) {
//            // Populate queue
//            for (int j = 0; j < iterations; j++) {
//                v2.enqueue(rnd.nextInt(v2_size*10));
//            }
//            long t_total = 0;
//            for (int j = 0; j < iterations; j++) {
//                long t_start = System.nanoTime();
//                v2.dequeue();
//                t_total += System.nanoTime() - t_start;
//            }
//            System.out.println(t_total/iterations);
//            v2_size += 100;
//        }
//        System.out.println();

        // TreeHeap enqueue
//        TreeHeap tree = new TreeHeap();
//        int tree_size = 100;
//        for (int i = 0; i < 20; i++) {
//            long t_total = 0;
//            for (int j = 0; j < iterations; j++) {
//                long t_start = System.nanoTime();
//                tree.enqueue(rnd.nextInt(tree_size*10));
//                t_total += System.nanoTime() - t_start;
//            }
//            System.out.println(t_total/iterations);
//            tree_size += 100;
//        }
//        System.out.println();
        
        // TreeHeap dequeue
//        TreeHeap tree = new TreeHeap();
//        int tree_size = 100;
//        for (int i = 0; i < 20; i++) {
//            // Populate queue
//            for (int j = 0; j < iterations; j++) {
//                tree.enqueue(rnd.nextInt(tree_size*10));
//            }
//            long t_total = 0;
//            for (int j = 0; j < iterations; j++) {
//                long t_start = System.nanoTime();
//                tree.dequeue();
//                t_total += System.nanoTime() - t_start;
//            }
//            System.out.println(t_total/iterations);
//            tree_size += 100;
//        }
//        System.out.println();
       
        // ArrayHeap enqueue
//        ArrayHeap array = new ArrayHeap();
//        int array_size = 100;
//        for (int i = 0; i < 20; i++) {
//            long t_total = 0;
//            for (int j = 0; j < iterations; j++) {
//                long t_start = System.nanoTime();
//                array.enqueue(rnd.nextInt(array_size*10));
//                t_total += System.nanoTime() - t_start;
//            }
//            System.out.println(t_total/iterations);
//            array_size += 100;
//        }
//        System.out.println();
        
        // ArrayHeap dequeue
//        ArrayHeap array = new ArrayHeap();
//        int array_size = 100;
//        for (int i = 0; i < 20; i++) {
//            // Populate queue
//            for (int j = 0; j < iterations; j++) {
//                array.enqueue(rnd.nextInt(array_size*10));
//            }
//            long t_total = 0;
//            for (int j = 0; j < iterations; j++) {
//                long t_start = System.nanoTime();
//                array.dequeue();
//                t_total += System.nanoTime() - t_start;
//            }
//            System.out.println(t_total/iterations);
//            array_size += 100;
//        }
//        System.out.println();

    }
}
