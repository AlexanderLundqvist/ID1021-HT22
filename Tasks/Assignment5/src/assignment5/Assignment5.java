package assignment5;
import java.util.*;

/**
 * This class tests different implementations of linked lists.
 * 
 * @author Alexander Lundqvist
 */
public class Assignment5 {

    /**
     * Controls the program flow.
     * 
     * @param args takes no arguments
     */
    public static void main(String[] args) {
        int iterations = 10000;
        LinkedList linkedList = new LinkedList();
        DynamicStack dynamicStack = new DynamicStack();
        
        System.out.println("Linked list");
        linkedList.benchmark(10, iterations);
        int linked_size = 10;
        for (int i = 0; i < 100; i++) {
            System.out.println(linkedList.benchmark(linked_size, iterations));
            linked_size += 10;
        }
        System.out.println();
        
    }
    
}
