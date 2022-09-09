package searching;

import java.util.*;

/*********************************** README ************************************
*
* Assignment 4: Searching with sorted data
* @author Alexander Lundqvist
* Created: 02-09-2022
*
* About this class:
* This class is used to benchmark different search operations on arrays with 
* sorted data.
*
*
*******************************************************************************/

public class Searching {
    
    /**
     * Generates an usorted integer array
     * 
     * @param n the size of the array
     * @return the generated array
     */
    private static int[] unsortedArray(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
            array[i] = rnd.nextInt(n - 1);
        }
        return array;
    }
    
    /**
     * Generates a sorted integer array
     * 
     * @param n the size of the array
     * @return the generated array
     */
    private static int[] sortedArray(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }
    
    /**
     * Controls the main flow of the program. Is responsible for the benchmarking
     * of the different search methods.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iterations  = 100000;
        //int iterations  = 1000; // For task 4
        LinearSearch linearSearch = new LinearSearch();
        BinarySearch binarySearch = new BinarySearch();
        SearchDouble searchDouble = new SearchDouble();
        
        // Linear unsorted
//        System.out.println("Linear unsorted");
//        int s1 = 100;
//        for (int i = 0; i < 100; i++) {
//            int[] array = unsortedArray(s1);
//            System.out.println(linearSearch.benchmarkUnsorted(array, iterations));
//            s1 += 100;
//        }
//        System.out.println();
        
        // Linear sorted
//        System.out.println("Linear sorted");
//        int s2 = 100;
//        for (int i = 0; i < 200; i++) {
//            int[] array = sortedArray(s2);
//            System.out.println(linearSearch.benchmarkSorted(array, iterations));
//            s2 += 100;
//        }
//        System.out.println();
        
        // Binary search
//        System.out.println("Binary search");
//        int s3 = 100;
//        binarySearch.benchmark(sortedArray(s3), iterations);
//        for (int i = 0; i < 300; i++) {
//            int[] array = sortedArray(s3);
//            System.out.println(binarySearch.benchmark(array, iterations));
//            s3 += 100;
//        }
//        System.out.println();
        
        // Double search      
//        System.out.println("Double search"); 
//        int s4 = 10;
//        searchDouble.benchmarkSearch(sortedArray(s4), sortedArray(s4), iterations);
//        for (int i = 0; i < 100; i++) {
//            int[] array = sortedArray(s4);
//            int[] keys = sortedArray(s4);
//            System.out.println(searchDouble.benchmarkSearch(array, keys, iterations));
//            s4 += 10;
//        }
//        System.out.println();

//        System.out.println("Double better search"); 
//        int s5 = 10;
//        searchDouble.benchmarkBetterSearch(sortedArray(s5), sortedArray(s5), iterations);
//        for (int i = 0; i < 100; i++) {
//            int[] array = sortedArray(s5);
//            int[] keys = sortedArray(s5);
//            System.out.println(searchDouble.benchmarkBetterSearch(array, keys, iterations));
//            s5 += 10;
//        }
//        System.out.println();

        System.out.println("Double old search"); 
        int s6 = 10;
        searchDouble.benchmarkOldSearch(sortedArray(s6), sortedArray(s6), iterations);
        for (int i = 0; i < 1000; i++) {
            int[] array = sortedArray(s6);
            int[] keys = sortedArray(s6);
            System.out.println(searchDouble.benchmarkOldSearch(array, keys, iterations));
            s6 += 10;
        }
        System.out.println();
    }
    
}
