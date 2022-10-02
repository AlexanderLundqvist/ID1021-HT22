package queues;

import java.util.*;

/**
 * This class implements a FIFO-queue data structure with a linked list 
 * implementation.
 *
 * @author Alexander Lundqvist
 */
public class LinkedQueue<Item> implements Iterable<Item>{
    private int size;
    private Node first; // Points to the start of the queue
    private Node last; // Points to the end of the queue
    
    /**
     * Initializes an empty queue. Only called once.
     */
    public LinkedQueue() {
        this.size = 0;
        this.first = null;
        this.last = null;
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
        //return (this.size == 0);
        return first == null;
    }
    
    /**
     * Adds an element to the back of the queue.
     * 
     * @param value the value of the element
     */
    public void enqueue(Item value) {
        Node oldLast = this.last;
        this.last = new Node(value);
        if(isEmpty()) this.first = this.last;
        else oldLast.next = this.last;
        size++;
    }
    
    /**
     * Removes the first element in the queue.
     * 
     * @return the de-queued node.
     */
    public Node dequeue() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty!");
        Node dequeued = this.first;
        this.first = first.next;
        size--;
        if (isEmpty()) this.last = null; // To completely "reset" the queue
        return dequeued;
    }
    
    /**
     * An iterator that iterates over the queue if FIFO order.
     * 
     * @return the iterator
     */
    public Iterator<Item> iterator()  {
        return new LinkedIterator(this.first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item value = current.value;
            current = current.next;
            return value;
        }
    }
    
    /**
     * Prints the contents of the queue.
     */
    public void print() {
        System.out.println("\nPrinting the contents of the queue:\n");
        for(Item value : this) {
            System.out.println("Value: " + value);
        }
        System.out.println();
    }

    /**
     * Main method with unit testing for the class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
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
