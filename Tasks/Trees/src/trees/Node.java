package trees;

/**
 * This class is a utility class that implements a node structure.
 *
 * @author Alexander Lundqvist
 */
public class Node {
    public Integer key;
    public String value;
    public Node left, right;
        
    public Node(Integer key, String value) {
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
    
    /**
     * Should only be performed on root node
     */
    public void DFSprint() {
        if(left != null) left.DFSprint();
        System.out.println("Key: " + key + "\tValue: " + value);
        if(right != null) right.DFSprint();  
    }
}
