package searching;

import java.util.*;

public class LinearSearch {
    
    // Default constructor
    public LinearSearch() {
        
    }
    
    
    public boolean unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
    
    public boolean sorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
            if (array[index] > key) {
                return false;
            }
        }
        return false;
    }
    
    public long benchmarkUnsorted(int[] array, int iterations) {
        Random rnd = new Random();
        long t_total = 0;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            unsorted(array, rnd.nextInt(array.length - 1));
            t_total += System.nanoTime() - t_start;
        }
        return (t_total/iterations);
    }
    
    public long benchmarkSorted(int[] array, int iterations) {
        Random rnd = new Random();
        long t_total = 0;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            sorted(array, rnd.nextInt(array.length - 1));
            t_total += System.nanoTime() - t_start;
        }
        return (t_total/iterations);
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
