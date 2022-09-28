package trees;

import java.util.*;

public class BinarySearch {
    public static Random rand = new Random();
    
    public static boolean search(Integer[] array, Integer key) {
        int lo = 0; 
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if (Objects.equals(array[mid], key)) return true;
            //if (array[mid] == key) return true;
            else if (array[mid] > key && mid > lo) hi = mid - 1;
            else if (array[mid] < key && mid < hi) lo = mid + 1;
            else return false;
        }
        return false;
    }
    
    public static long benchmark(Integer[] array, int iterations) {
        long totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            search(array, rand.nextInt(array.length - 1));
            totalTime += System.nanoTime() - startTime;
        }
        return (totalTime/iterations);
    }    

    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
