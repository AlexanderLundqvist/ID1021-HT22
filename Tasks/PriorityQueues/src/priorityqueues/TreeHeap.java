package priorityqueues;

import java.util.*;

public class TreeHeap {
    private Node root;
    private int size;
    private int leftSize;
    private int rightSize;
    
    public TreeHeap() {
        this.root = null;
        this.size = 0;
        this.leftSize = 0;
        this.rightSize = 0;
    }

    public class Node {
        public Integer value;
        public Node leftBranch;
        public Node rightBranch;

        public Node(Integer value) {
            this.value = value;
            this.rightBranch = null;
            this.rightBranch = null;
        }
    }
    
    public void enqueue(Integer value) {
        if(isEmpty()) {
            this.root = new Node(value);
        } 
        
        //
        
        size++;
    }
    
    public Integer dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        
        //
        
        size--;
        return 0;
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
