package queues;

import java.util.*;

/**
 * This class implements a FIFO-queue data structure with a dynamic array 
 * implementation.
 *
 * @author Alexander Lundqvist
 */
public class DynamicQueue<Item> {
    private static final int INIT_CAPACITY = 8;
    private Item[] queue; // Allocated queue space
    private int size; // Amount of entries in queue
    private int indexFirst, indexLast;   
    
    /**
     * Initializes an empty queue.
     */
    public DynamicQueue() {
        this.queue = (Item[]) new Object[INIT_CAPACITY];
        this.size = 0;
        this.indexFirst = 0; 
        this.indexLast = 0; 
    }
    
    /**
     * Adds an element to the back of the queue.
     * 
     * @param value the value of the element
     */
    public void enqueue(Item value) {
        if(size == queue.length) resize(queue.length*2);
        queue[indexLast++] = value;
        if(indexLast == queue.length) indexLast = 0; // Wrap around
        size++;
    }
    
    /**
     * Removes the first element in the queue.
     * 
     * @return the de-queued element.
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty!");
        Item dequeued = queue[indexFirst];
        queue[indexFirst] = null;
        indexFirst++;
        size--;
        // Wrap
        if(indexFirst == queue.length) indexFirst = 0; 
        
        if (size > 0 && size == queue.length/4) resize(queue.length/2);
        return dequeued;
    }
    
    
    private void resize(int amount) {
        Item[] newQueue = (Item[]) new Object[amount];
        int first = indexFirst;
        for (int i = 0; i < this.size; i++) {
            newQueue[i] = this.queue[first++];
            if (first == queue.length) first = 0; // Wrap around 
        }
        this.queue = newQueue;
        indexFirst = 0;
        indexLast = size;
    }
    
    /**
     * Returns the size of the queue
     * 
     * @return the size
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Tells if the queue is empty or not.
     * 
     * @return true if empty, else false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /**
     * Prints the contents of the queue.
     */
    public void print() {
        System.out.println("\nPrinting the contents of the queue:\n");
        for (int i = 0; i < this.size; i++) {
            System.out.println("Value: " + queue[i]);
        }
        System.out.println();
    }

    /**
     * Main method with unit testing for the class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.dequeue();
        //queue.dequeue(); // Should give error
    }

}
