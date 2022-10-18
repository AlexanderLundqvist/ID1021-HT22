package priorityqueues;

import java.util.*;

public class ArrayHeap {
    private Integer[] heap;
    private int nodes; // Elements in the heap
    
    public ArrayHeap(int size) {
        this.heap = new Integer[size];
        this.nodes = 0;
    }
    
    public void enqueue(Integer value) {
        if (isFull()) System.out.println("Queue is full!");
        
        
        
        this.nodes++;
    }
    
    public Integer dequeue() {
        if (isEmpty()) System.out.println("Queue is empty!");
        
        
        
        this.nodes--;
        return 0;
    }
    
    public boolean isEmpty() {
        return this.nodes == 0;
    }
    
    public boolean isFull() {
        return this.nodes == this.heap.length;
    }
    
    /**
     * Prints the contents of the queue.
     */
    public void print() {
        
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        ArrayHeap test = new ArrayHeap(5);
        test.enqueue(5);
        test.enqueue(1);
        test.enqueue(4);
        test.enqueue(3);
        test.enqueue(2);
        test.print();
        System.out.println();
        
        test.dequeue();
        test.dequeue();
        test.print();
        System.out.println();
        
        test.dequeue();
        test.dequeue();
        test.print();
        System.out.println();
        
        test.dequeue();
        test.print();
        System.out.println();
        
        test.dequeue();
    }
}
