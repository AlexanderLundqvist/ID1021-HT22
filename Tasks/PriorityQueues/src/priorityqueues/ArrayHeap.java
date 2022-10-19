package priorityqueues;

import java.util.*;

public class ArrayHeap {
    private Integer[] heap;
    private int size; // Elements in the heap
    
    public ArrayHeap(int capacity) {
        this.heap = new Integer[capacity+1];
        this.size = 0;
    }
    
    public void enqueue(Integer value) {
        if (isFull()) System.out.println("Queue is full!");
        
        heap[++size] = value;
        bubble(size);

        this.size++;
    }
    
    private void bubble(int k) {
        while (k > 1 && k-1/2 > k) {
            swap(k-2/2, k);
            k = k-1/2;
        }
    }
    
    public Integer dequeue() {
        if (isEmpty()) System.out.println("Queue is empty!");
        
        Integer min = this.heap[1];
        swap(1, this.size--);
        sink(1);
        this.heap[this.size+1] = null;         
        this.size--;
        
        return min;
    }
    
    private void sink(int k) {
        while (2*k <= this.size) {
            int j = 2*k;
            if ((j < this.size) && j > (j+1)) j++;
            if (!(k > j)) break;
            swap(k, j);
            k = j;
        }
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
        ArrayHeap test = new ArrayHeap(10);
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
