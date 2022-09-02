package calculatorpolishreverse;

public class Stack {
    private Item stack[];
    private int stackPointer;
    
    
    public Stack(int size) {
        this.stack = new Item[size];
        this.stackPointer = 0;
    }
    
    public void push(Item item) {
        this.stack[this.stackPointer++] = item;
    }
    
    public Item pop() {
        Item poppedItem = this.stack[--this.stackPointer];
        this.stack[this.stackPointer] = null;
        return poppedItem;
    }
    
    
    public void stackToString() {
        int sp = this.stackPointer;
        while (sp > 0) {
            System.out.println(this.stack[sp--]);
        }
    }
    
}
