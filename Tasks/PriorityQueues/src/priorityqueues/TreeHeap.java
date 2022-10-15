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

public class TreeHeap {
    private Node root;
    
    // Default constructor
    public TreeHeap() {
    }
    
     /**
     * This class is a utility class that implements a node structure.
     */
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key    = key;
            this.value  = value;
            this.left   = this.right = null;
        }

        /**
         * Prints current node
         */
        public void print() {
            System.out.println("Key: " + key + "\tValue: " + value);
        }

    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
