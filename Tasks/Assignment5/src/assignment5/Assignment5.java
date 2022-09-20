package assignment5;
import java.util.*;

/**
 * This class tests different implementations of linked lists.
 * 
 * @author Alexander Lundqvist
 */
public class Assignment5 {
    
    public static int[] append(int[] static_array, int[] array) {
        int[] newArray = new int[static_array.length + array.length];
        
        return newArray;
    }
    
    /**
     * Controls the program flow.
     * 
     * @param args takes no arguments
     */
    public static void main(String[] args) {
        int iterations = 10000;
        int size = 10;
        LinkedList linkedList = new LinkedList();
        DynamicStack dynamicStack = new DynamicStack();
        
        System.out.println("Linked list");
        linkedList.benchmark(size, 10, iterations);
        int linked_size = 10;
        for (int i = 0; i < 100; i++) {
            System.out.println(linkedList.benchmark(size, linked_size, iterations));
            linked_size += 10;
        }
        System.out.println();
        
    }
    
}
