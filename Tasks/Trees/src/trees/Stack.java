package trees;

/**
 * This is a simple dynamic stack that handles generic objects and primitive values.
 * 
 * @author Alexander Lundqvist
 */
public class Stack<Item> {
    private Item[] stack;
    private int stackPointer;   
    
    public Stack() {
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
    
    // Use this if generics don't work.
    /*
    private Node[] stack;
    private int stackPointer;   
    
    public Stack() {
        this.stack = new Node[1];
        this.stackPointer = 0;
    }
    
    public void push(Node item) {
        if (this.stackPointer == size())
            resize(2*size());
        this.stack[this.stackPointer++] = item;
    }
    
    public Node pop() {
        Node poppedItem = this.stack[--this.stackPointer];
        this.stack[this.stackPointer] = null;  
        if (this.stackPointer > 0 && this.stackPointer == size()/4)
            resize(size()/2);
        return poppedItem;
    }
    
    private void resize(int amount) {
        Node[] newStack = new Node[amount];   
        for (int i = 0; i < this.stackPointer; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
        newStack = null;
    }
    
    public int size() {
        return (this.stack.length);
    }
    */
}
