package assignment5;

/**
 * A simple linked list.
 * 
 * @author Alexander
 */
public class LinkedList{
    int head;
    LinkedList tail;
    
    
    public LinkedList () {
        
    }
    
    public LinkedList (int item) {
        
    }
    
    public int GetHead () {
        return this.head;
    }
    
    public LinkedList GetTail() {
        return this.tail;
    }
    
    public void append (LinkedList b) {
        LinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public void listToString () {
        StringBuilder formatedString = new StringBuilder();
        int counter = 0;
        for (Item item : this) {
            counter++;
            if (item != null) {
                formatedString.append("[");
                formatedString.append(item);
                formatedString.append("]");
                if (counter < size) {
                    formatedString.append(","); 
                }
            }
        }
        formatedString.append("} -> Sentinel");
        System.out.println(formatedString.toString());
    }
    
    public long benchmark(int size, int iterations) {
        long min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            //sort(array);
            long t = System.nanoTime() - t_start;
            if (t < min) {
                min = t;
            }
        }
        return min;
    }

    /**
     * Main method with unit testing for the class.
     * 
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
