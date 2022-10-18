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
 * This class implements a priority queue with enqueue time complexity of O(n)
 * and dequeue time complexity of O(1).
 * 
 * @author Alexander
 */
public class ListHeapV2 {
    //private Node first; // Points to the end of the queue
    private Node last; // Points to the start of the queue
    private int size;
    
    /**
     * Initializes an empty queue. Only called once.
     */
    public ListHeapV2() {
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
        return this.last == null;
    }
    
    // O(n)
    public void enqueue(Integer value) {
        Node newNode = new Node(value);
        if(isEmpty()) this.last = newNode;
        // In case of only one element
        else if (this.last.next == null) {
            if (newNode.value < this.last.value) {
                newNode.next = this.last;
                this.last = newNode;
            }
            else {
                this.last.next = newNode;
            }         
        }
        // Guard if we start with a smaller value
        else if (newNode.value < this.last.value) {
            newNode.next = this.last;
            this.last = newNode;
        }
        else {
            Node current = this.last;
            while(current.next != null && current.next.value < newNode.value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        this.size++;
    }
    
    // O(1)
    public Integer dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Integer dequeued = this.last.value;
        this.last = this.last.next;
        this.size--;
        return dequeued;
    }
    
    /**
     * Prints the contents of the queue.
     */
    public void print() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
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
        ListHeapV2 test = new ListHeapV2();
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
