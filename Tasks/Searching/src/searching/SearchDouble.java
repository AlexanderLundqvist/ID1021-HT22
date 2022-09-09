package searching;

import java.util.*;

/*

Remember the task you had in a previous assignment where you found all
duplicates in two unsorted arrays. For each of the items in the first array
you searched through the whole second array looking for duplicates. How
would this strategy change if you would be given two sorted arrays?
If the arrays are sorted we could as before go through the first list, item by
item, but we could now be smart when looking through the second list. We
could use our implementation of the binary search algorithm and determine
if a duplicate is found. Do some benchmark and present the improvement
in run time that you get. Can we do even better?
Let's rewrite the algorithm and do as follows. Keep track of the next
element in the first list. If the next element in the second list is smaller than
the next in the first, then move forward in the second list. If it is equal (and
then we found a duplicate) or greater then we move forward in the first list.
Assume that the two arrays themselves do not contain any duplicates
(use the generator in the previous example). Run some benchmarks and
compare the execution time with the run time in your previous assignment,
the version using binary search and your final version.

*/

public class SearchDouble {
    
    // Default constructor
    public SearchDouble() {
    }
    
    public void Search() {
        
    }
    
    public void benchmark(int[] array_A, int[] array_B, int iterations) {
        
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
