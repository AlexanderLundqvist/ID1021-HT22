package queues;

import java.util.*;

/**
 * This class implements a FIFO-queue data structure with a dynamic array 
 * implementation.
 *
 * @author Alexander Lundqvist
 */
public class DynamicQueue<Item> {
    private Item[] stack;
    private int stackPointer;   
    
    public DynamicQueue() {
        this.stack = (Item[]) new Object[1];
        this.stackPointer = 0;
    }
    
    public void push(Item item) {
        if (this.stackPointer == size())
            resize(2*size());
        this.stack[this.stackPointer++] = item;
    }
    
    public Item pop() {
        Item poppedItem = this.stack[--this.stackPointer];
        this.stack[this.stackPointer] = null;  
        if (this.stackPointer > 0 && this.stackPointer == size()/4)
            resize(size()/2);
        return poppedItem;
    }
    
    private void resize(int amount) {
        Item[] newStack = (Item[]) new Object[amount];   
        for (int i = 0; i < this.stackPointer; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
    }
    
    public int size() {
        return (this.stack.length);
    }
    
    public boolean isEmpty() {
        return this.stackPointer == 0;
    }

    /**
     * Main method with unit testing for the class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DynamicQueue queue = new LinkedQueue();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Should give error
    }

}
