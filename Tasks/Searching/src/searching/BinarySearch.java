package searching;

import java.util.*;

public class BinarySearch {
    
    // Default constructor
    public BinarySearch() {
    }
    
    public static boolean search(int[] array, int key) {
        int lo = 0; 
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if (array[mid] == key) return true;
            else if (array[mid] > key && mid > lo) hi = mid - 1;
            else if (array[mid] < key && mid < hi) lo = mid + 1;
            else return false;
        }
        return false;
    }
    
    public static long benchmark(int[] array, int iterations) {
        Random rnd = new Random();
        long t_total = 0;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            search(array, rnd.nextInt(array.length - 1));
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
