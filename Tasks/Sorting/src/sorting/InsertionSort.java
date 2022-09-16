package sorting;

import java.util.*;

public class InsertionSort {
    
    // Default constructor
    public InsertionSort() {
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
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    swap(array, j, j-1);
                }
            }
        }    
    }
    
    public long benchmark(int size, int iterations) {
        long t_total = 0;
        for (int i = 0; i < iterations; i++) {
            int[] array = unsortedArray(size); 
            long t_start = System.nanoTime();
            sort(array);
            t_total += System.nanoTime() - t_start;
        }
        return (t_total/iterations);
    }
    
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        int[] array = unsortedArray(10);
        InsertionSort test = new InsertionSort();
        System.out.println("Array before sorting");
        arrayToString(array);
        test.sort(array);
        System.out.println("\n\nArray after sorting");
        arrayToString(array);
    }
}
