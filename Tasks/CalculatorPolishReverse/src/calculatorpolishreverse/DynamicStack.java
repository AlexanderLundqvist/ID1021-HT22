package calculatorpolishreverse;

public class DynamicStack {
    private Item stack[];
    private int stackPointer;
    
    
    public DynamicStack() {
        this.stack = new Item[1]; // Must initialize to 1, else the resizing won't work
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
        Item[] newStack = new Item[amount];
       
        for (int i = 0; i < this.stackPointer; i++) {
            newStack[i] = this.stack[i];
        }
        
        this.stack = newStack;
        newStack = null;
    }
    
    public int size() {
        return (this.stack.length);
    }
    
    public void stackToString() {
        int sp = this.stackPointer;
        while (sp > 0) {
            System.out.println(this.stack[sp--]);
        }
    }
    
}
