package sorting;

import java.util.*;


/**
 *
 * @author Alexander
 */
public class Sorting {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iterations  = 100000;
        SelectionSort selection = new SelectionSort();
        InsertionSort insertion = new InsertionSort();
        MergeSort     merge     = new MergeSort();
        
        // Selection sort
//        System.out.println("Selection sort");
//        selection.benchmark(10, iterations);
//        int selection_size = 10;
//        for (int i = 0; i < 20; i++) {
//            System.out.println(selection.benchmark(selection_size, iterations));
//            selection_size += 10;
//        }
//        System.out.println();
        
        // Insertion sort
//        System.out.println("Insertion sort");
//        insertion.benchmark(10, iterations);
//        int insertion_size = 10;
//        for (int i = 0; i < 20; i++) {
//            System.out.println(insertion.benchmark(insertion_size, iterations));
//            insertion_size += 10;
//        }
//        System.out.println();
        
        // Merge sort
        System.out.println("Merge sort");
        merge.benchmark(10, iterations);
        int merge_size = 10;
        for (int i = 0; i < 100; i++) {
            System.out.println(merge.benchmark(merge_size, iterations));
            merge_size += 10;
        }
        System.out.println();
        
    }
    
}
