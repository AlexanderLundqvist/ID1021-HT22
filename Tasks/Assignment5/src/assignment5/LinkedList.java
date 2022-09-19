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
    
    public boolean isEmpty() {
        if(this.size == 0) return true;
        else return false;
    }
    
    public void push(int value) {
        Node newHead = new Node(value, this.head);
        this.head = newHead;
        size++;
    }
    
    public Node pop() {
        if(isEmpty()) {
            System.out.println("The list is empty!");
            return null;
        }
        Node popped = head;
        this.head = head.next;
        size--;
        return popped;
    }

    public void print() {
        if(isEmpty()) System.out.println("The list is empty!");
        else {
            System.out.println(head.getValue() + " <- Top of the stack");
            Node current = head.next;
            while(current != null) {
                System.out.println(current.getValue());
                current = current.next;
            }
        }
    }
    
    /**
     * Main method with unit testing for the class.
     * 
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.print();
        System.out.println();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.print();
        System.out.println();
        list.pop();
        
        list.print();
        System.out.println();
        list.pop();
        list.pop();
        list.pop();
        list.pop();
        System.out.println();
        list.pop();
        System.out.println();
        list.print();
        
    }
}
