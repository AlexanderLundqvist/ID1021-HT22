package priorityqueues;

/*
The simplest way of implementing a priority queue is to use a regular list
so let's start there and look at the pros and cons.
Implement a priority queue that holds integers, smaller numbers have
higher priority. Your first implementation should have an add method with
a time complexity of O(1) and a remove time complexity of O(n) where n
is the number of elements in the queue.
Now make a second implementation where the situation is the reversed
i.e. it's expensive to add new elements but removal can be done in O(1).
Benchmark the two implementations and show the difference.
Are there any situations where you would prefer one over the other? 
*/

import java.util.*;

/**
 * This class implements a priority queue with enqueue time complexity of O(1)
 * and dequeue time complexity of O(n).
 * 
 * @author Alexander
 */
public class ListHeapV1 {
    // private Node first; // Points to the end of the queue
    private Node last; // Points to the start of the queue
    private int size;
    
    /**
     * Initializes an empty queue. Only called once.
     */
    public ListHeapV1() {
        //this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    /**
    * This class is a utility class that implements a node structure.
    *
    */
    public class Node {
        public Integer value;
        public Node next;
        public Node prev;

        /**
         * Initializes a free floating node.
         * 
         * @param value the value of the node
         */
        public Node(Integer value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    

    public boolean isEmpty() {
        return last == null;
    }
    
    // O(1)
    public void enqueue(Integer value) {
        Node newNode = new Node(value);
        if(isEmpty()) this.last = newNode;
        else {
            newNode.next = this.last;
            this.last.prev = newNode;
            this.last = newNode;
        }
        this.size++;
    }
    
    // O(n)
    public Integer dequeue() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty!");
        Node current = this.last;
        // In case of only one element
        if (this.last.next == null) {
            this.last = null;
            return current.value;
        }
        
        Node min = this.last;
        
        while(current != null) {
            if (current.value < min.value) {
                min = current;
            }
            current = current.next;
        }

        min.prev.next = min.next;
        this.size--;
        return min.value;
    }
    
    
    /**
     * Prints the contents of the queue.
     */
    public void print() {
        Node current = this.last;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        ListHeapV1 test = new ListHeapV1();
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
