package sorting;

import java.util.*;

public class MergeSort {
    
    // Default constructor
    public MergeSort() {
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
    
    private void merge (int[] array, int[] aux, int low, int mid, int high) {
        // copy to aux[]
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }

        // merge back to a[]
        int i = low, j = mid+1;
        for (int k = low; k <= high; k++) {
            if      (i > mid)               array[k] = aux[j++];
            else if (j > high)              array[k] = aux[i++];
            else if ((aux[j] < aux[i]))     array[k] = aux[j++];
            else                            array[k] = aux[i++];
        }
    }
    
    private void sort(int[] array, int[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid);
        sort(array, aux, mid + 1, high);
        merge(array, aux, low, mid, high);
    }
    
    public void sort(int[] array) {
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length - 1);
    }
    
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
        MergeSort test = new MergeSort();
        System.out.println("Array before sorting");
        arrayToString(array);
        test.sort(array);
        System.out.println("\n\nArray after sorting");
        arrayToString(array);
    }
}
