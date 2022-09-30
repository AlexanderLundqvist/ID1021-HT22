package trees;

import java.util.*;

public class BinaryTree implements Iterable<String>{
    public Node root;
    
    public BinaryTree() {
        root = null;
    }
    
    public void put(Integer key, String value) {
        root = put(root, key, value);
    }
    
    public void put(Integer[] keys, String[] values) {
        for(int i = 0; i < keys.length; i++) {
            put(keys[i], values[i]);
        }
    }
    
    private Node put(Node node, Integer key, String value){
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
    
    public String get(Integer key) {
        return get(root, key);
    }

    private String get(Node node, Integer key) {
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
    
    @Override
    public Iterator<String> iterator() {
        return new TreeIterator();
    }
    
    /**
     * 
     */
    public class TreeIterator implements Iterator<String> {
        private Node current;
        private Stack<Node> stack;

        public TreeIterator() {
            this.stack = new Stack<Node>();
            this.current = root;       
            
            // Travel down left side
            while (this.current != null) {
                this.stack.push(this.current);
                this.current = this.current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            
            Node temp = this.stack.pop();
            String value = temp.value;
            
            if (temp.right != null) {
                this.current = temp.right;
                while (this.current != null) {
                    this.stack.push(this.current);
                    this.current = this.current.left;
                }
            } 
            
            return value;        
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Main method with unit testing for the class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.put(5,"AAA");
        tree.put(2,"BBB");
        tree.put(1,"CCC");
        tree.put(8,"DDD");
        tree.put(6,"EEE");
        tree.put(3,"FFF");
        for (String value : tree) System.out.println("Next value: " + value);
    }
}
