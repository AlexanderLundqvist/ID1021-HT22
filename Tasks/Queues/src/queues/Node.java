package queues;

/**
 * This class is a utility class that implements a node structure.
 *
 * @author Alexander Lundqvist
 */
public class Node<Item> {
    public Item value;
    public Node next;
    
    /**
     * Initializes a free floating node.
     * 
     * @param value the value of the node
     */
    public Node(Item value) {
        this.value = value;
        this.next = null;
    }
    
    /**
     * Initializes a node with reference to the following node.
     * 
     * @param value the value of the node
     * @param node a pointer to next node
     */
    public Node(Item value, Node node) {
        this.value = value;
        this.next = node;
    }
    
    /**
     * Prints current node
     */
    public void print() {
        System.out.println("Value: " + value);
    }
}
