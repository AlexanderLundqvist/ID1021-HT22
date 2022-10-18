package priorityqueues;

import java.util.*;

public class ArrayHeap {
    private Integer[] heap;
    private int size; // Elements in the heap
    
    public ArrayHeap(int capacity) {
        this.heap = new Integer[capacity];
        this.size = 0;
    }
    
    public void enqueue(Integer value) {
        if (isFull()) System.out.println("Queue is full!");
        
        heap[++size] = value;
        swim(size);

        this.size++;
    }
    
    public Integer dequeue() {
        if (isEmpty()) System.out.println("Queue is empty!");
        
        
        
        this.size--;
        return 0;
    }
    
    
    
    private void swap(int a, int b) {
        Integer temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;
    }
    
    private boolean isEmpty() {
        return this.size == 0;
    }
    
    private boolean isFull() {
        return this.size == this.heap.length;
    }
    
    /**
     * Prints the contents of the queue.
     */
    public void print() {
        for(int i = 0; i < this.heap.length; i++) System.out.println(this.heap[i]);
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
