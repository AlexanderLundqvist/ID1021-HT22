package trees;

/**
 * This class is a utility class that implements a node structure.
 *
 * @author Alexander Lundqvist
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

}
