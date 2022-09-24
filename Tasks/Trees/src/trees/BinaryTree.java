package trees;

public class BinaryTree {
    private Node root;
    
    public BinaryTree() {
        root = null;
    }
    
    public void put(Integer key, Integer value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Integer key, Integer value){
        if (node == null) return new Node(key, value); // Om den aktuella noden är tom, sätt in en ny nod

        int cmp = key.compareTo(node.key); // Jämför input key med aktuella nodens key

        if      (cmp < 0) node.left = put(node.left, key, value); // Om inskickad key är mindre än nodens key
                                                                  // för den nod vi kollar, kalla rekursivt
                                                                  // med den nuvarande nodens vänstra child då alla
                                                                  // keys till vänster är mindre

        else if (cmp > 0) node.right = put(node.right, key, value); // Om inskickad key är större än nodens key
                                                                    // Kalla igen rekursit fast nu med höger child
                                                                    // då alla keys till höger är större

        else    node.value = value; // Om jämförelsen var lika, då ersätter vi värdet
        return node; // Returnera den noden så att trädet resetar sina länkar korrekt när vi rekurserar tillbaka
    }
    
    public Integer get(Integer key) {
        return get(root, key);
    }

    private Integer get(Node node, Integer key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key); // Jämför med den inskickade noden
        if      (cmp < 0) return get(node.left, key); // Om inskickad key är mindre än nodens key
                                                      // för den nod vi kollar, kalla rekursivt
                                                      // med den nuvarande nodens vänstra child då alla
                                                      // keys till vänster är mindre

        else if (cmp > 0) return get(node.right, key); // Om inskickad key är större än nodens key
                                                       // Kalla igen rekursit fast nu med höger child
                                                       // då alla keys till höger är större

        else              return node.value; // Om värdet är lika så har vi kommit till rätt nod och returnerar det värdet
    }
    
    public Long benchmark() {
        return 0L;
    }
    
    /**
     * Main method with unit testing for the class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Unit tests go here
    }

}
