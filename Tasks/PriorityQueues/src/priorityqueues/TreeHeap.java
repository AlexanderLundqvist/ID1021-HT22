package priorityqueues;

import java.util.*;

public class TreeHeap {
    private Node root;
    private int size;

    
    public TreeHeap() {
        this.root = null;
        this.size = 0;
    }

    public class Node {
        public Integer value;
        public int subNodes;
        public Node parent;
        public Node leftBranch;
        public Node rightBranch;

        public Node(Integer value) {
            this.value = value;
            this.subNodes = 0;
            this.parent = null;
            this.rightBranch = null;
            this.rightBranch = null;
        }
    }
    
    
    public void enqueue(Integer value) {
        // Empty queue
        if(isEmpty()) {
            this.root = new Node(value);
        } 
        
        // All other cases
        if(this.root.value < value) {
            
        }
        
        if(this.root.value >= value) {
            
        }
        
        size++;
    }
    
    // Recursive function?
    
    public Integer dequeue() {
        // Empty queueu
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        // Only root node
        if (this.root.leftBranch == null && this.root.rightBranch == null) {
            Integer dequeuedValue = this.root.value;
            this.root = null;
            this.size = 0;
            return dequeuedValue;
        }
        // All other cases
        Integer dequeuedValue = this.root.value;
                
        size--;
        return dequeuedValue;
    }
    
    public void increment() {
        
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /**
     * Prints the contents of the queue in DF-order.
     */
    public void print() {
        print(this.root);
    }
    
    private void print(Node node) {
        if (node.leftBranch != null) print(node.leftBranch);
        System.out.println(node);
        if (node.rightBranch != null) print(node.rightBranch);
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        TreeHeap test = new TreeHeap();
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
