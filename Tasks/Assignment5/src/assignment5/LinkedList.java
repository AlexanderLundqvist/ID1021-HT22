package assignment5;

/**
 * A simple linked list.
 * 
 * @author Alexander
 */
public class LinkedList{
    private int size;
    private Node head; // Points to the top of the stack
    
    /**
     * Helper node class.
     */
    private class Node {
        private int value;
        private Node next;
        
        public Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }
        
        public int getValue() {
            return this.value;
        }
    }
    
    public LinkedList() {
        this.size = 0;
        this.head = null;
    }
    
    public int size() {
        return this.size;
    }
    
    public void push(int value) {
        Node newHead = new Node(value, this.head);
        this.head = newHead;
        size++;
    }
    
    public Node pop() {
        Node popped = head;
        this.head = head.next;
        size--;
        return popped;
    }

    public void listToString() {
        while() {
            
        }
    }
    
    /**
     * Main method with unit testing for the class.
     * 
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
