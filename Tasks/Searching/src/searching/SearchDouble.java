package searching;

import java.util.*;

/*

Remember the task you had in a previous assignment where you found all
duplicates in two unsorted arrays. 
For each of the items in the first array you searched through the whole second 
array looking for duplicates. How would this strategy change if you would be 
given two sorted arrays?
If the arrays are sorted we could as before go through the first list, item by
item, but we could now be smart when looking through the second list. 
We could use our implementation of the binary search algorithm and determine
if a duplicate is found. 
Do some benchmark and present the improvement in run time that you get. 

Can we do even better?
Let's rewrite the algorithm and do as follows. 
Keep track of the next element in the first list. 
If the next element in the second list is smaller than
the next in the first, then move forward in the second list. 
If it is equal (and then we found a duplicate) or greater then we move forward 
in the first list.
Run some benchmarks and compare the execution time with the run time in your 
previous assignment, the version using binary search and your final version.

*/

public class SearchDouble {
    BinarySearch binarySearch;
    
    // Default constructor
    public SearchDouble() {
        this.binarySearch = new BinarySearch();
    }
    
    public void search(int[] sortedArray, int[] sortedKeys) {
        int sum = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (binarySearch.search(sortedArray, sortedKeys[i])) {
                sum++;
            }
        }
    }
    
    public void betterSearch(int[] sortedArray, int[] sortedKeys) {
        int arrayIndex = 0;
        int keysIndex = 0;
        int duplicates = 0;
        
        while (arrayIndex < sortedArray.length && keysIndex < sortedKeys.length) {
            if (sortedArray[arrayIndex] < sortedKeys[keysIndex]) {
                arrayIndex++;
            }
            else if (sortedArray[arrayIndex] == sortedKeys[keysIndex]) {
                duplicates++; // Duplicate found
                keysIndex++;
            }
            else if (sortedArray[arrayIndex] > sortedKeys[keysIndex]) {
                keysIndex++;
            }
        }
        
    }
    
    public void oldSearch(int[] sortedArray, int[] sortedKeys) {    
        int dummy = 0;
        for (int i = 0; i < sortedKeys.length; i++) {
            int key = sortedKeys[i];           
            for (int j = 0; j < sortedArray.length ; j++) {
                if (sortedArray[j] == key) {
                    dummy++;
                    //break;
                }
            }
        }
    }
    
    public long benchmarkSearch(int[] sortedArray, int[] sortedKeys, int iterations) {
        long t_total = 0;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            search(sortedArray, sortedKeys);
            t_total += System.nanoTime() - t_start;
        }
        return (t_total/iterations);
    }
    
    public long benchmarkBetterSearch(int[] sortedArray, int[] sortedKeys, int iterations) {
        long t_total = 0;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            betterSearch(sortedArray, sortedKeys);
            t_total += System.nanoTime() - t_start;
        }
        return (t_total/iterations);
    }
    
    public long benchmarkOldSearch(int[] sortedArray, int[] sortedKeys, int iterations) {
        long t_total = 0;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            oldSearch(sortedArray, sortedKeys);
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
