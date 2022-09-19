package assignment5;

import java.util.*;

public class DynamicStack {
    private int[] stack;
    private int stackPointer;
    
    
    public DynamicStack() {
        this.stack = new int[1]; // Must initialize to 1, else the resizing won't work
        this.stackPointer = 0;
    }
    
    public void push(int item) {
        if (this.stackPointer == size())
            resize(2*size());
        this.stack[this.stackPointer++] = item;
    }
    
    public int pop() {
        int poppedItem = this.stack[--this.stackPointer];
        
        this.stack[this.stackPointer] = -1;
        
        if (this.stackPointer > 0 && this.stackPointer == size()/4)
            resize(size()/2);
        
        return poppedItem;
    }
    
    private void resize(int amount) {
        int[] newStack = new int[amount];
       
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
