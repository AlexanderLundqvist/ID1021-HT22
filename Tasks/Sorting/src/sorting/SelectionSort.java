package sorting;

import java.util.*;

public class SelectionSort {
    
    // Default constructor
    public SelectionSort() {
    }
    
    private static int[] unsortedArray(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
            array[i] = rnd.nextInt(n*10);
        }
        return array;
    }
    
    private void swap (int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    private static void arrayToString (int[] array) {
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            }
            else System.out.print(array[i]);
        }
        System.out.print("]");
        System.out.println();
    }
    
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index == i) {/*do nothing*/}
            else            swap(array, index, i);
        }
    }
    
//    public long benchmark(int size, int iterations) {
//        long t_total = 0;
//        for (int i = 0; i < iterations; i++) {
//            int[] array = unsortedArray(size); 
//            long t_start = System.nanoTime();
//            sort(array);
//            t_total += System.nanoTime() - t_start;
//        }
//        return (t_total/iterations);
//    }
    
    public long benchmark(int size, int iterations) {
        long min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            int[] array = unsortedArray(size); 
            long t_start = System.nanoTime();
            sort(array);
            long t = System.nanoTime() - t_start;
            if (t < min) {
                min = t;
            }
        }
        return min;
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        int[] array = unsortedArray(10);
        SelectionSort test = new SelectionSort();
        System.out.println("Array before sorting");
        arrayToString(array);
        test.sort(array);
        System.out.println("\n\nArray after sorting");
        arrayToString(array); 
    }
}
