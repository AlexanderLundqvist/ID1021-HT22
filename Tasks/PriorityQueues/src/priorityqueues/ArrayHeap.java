package priorityqueues;

import java.security.SecureRandom;
import java.util.*;


/**
 * This class represents a binary heap in an array structure.
 * @author Adrian Jonsson
 * Re-implemented by Alexander Lundqvist
 */
public class ArrayHeap {
    private final int[] heap; // store items at indices 1 to n
    private int size; // number of items in heap
    private final int capacity;

    public ArrayHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[this.capacity];
    }

    private int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex + 1);
    }

    private int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex + 2);
    }

    private int parent(int childIndex) {
        return ((childIndex - 1) / 2);
    }

    private boolean hasLeftChild(int index) {
        return (getLeftChildIndex(index) < this.size);
    }

    private boolean hasRightChild(int index) {
        return (getRightChildIndex(index) < this.size);
    }

    private boolean hasParent(int index) {
        return (parent(index) >= 0);
    }

    private int leftChildValue(int parentIndex) {
        return this.heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChildValue(int parentIndex) {
        return this.heap[getRightChildIndex(parentIndex)];
    }

    private int parentValue(int childIndex) {
        return this.heap[parent(childIndex)];
    }

    private void swap(int a, int b) {
        int temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;
    }

    private void bubble() {
        int index = this.size - 1; // index to last element in heap
        while (hasParent(index) && parentValue(index) > heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    private void sink() {
        int index = 0; // where we had the old root
        while (hasLeftChild(index)) {
            int smallestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChildValue(index) < leftChildValue(index)) {
                smallestChildIndex = getRightChildIndex(index);
            }
            if (this.heap[index] < heap[smallestChildIndex]) {
                break;
            } else {
                swap(index, smallestChildIndex);
            }
            index = smallestChildIndex;
        }
    }

    public int dequeue() {
        if (this.size == 0) {
            System.out.println("Heap is empty");
            throw new NoSuchElementException();
        }
        int returnElement = this.heap[0];
        this.heap[0] = this.heap[this.size - 1]; // set last element as root
        this.size--;
        sink(); // let the new root sink down
        return returnElement;
    }

    public void enqueue(int item) {
        if (this.size == capacity) {
            System.out.println("Heap is full. Can't add item");
            return;
        } // items in queue will always be a value that gives an index where there is
          // nothing inserted yet
        this.heap[this.size] = item;
        this.size++;
        bubble();
    }

    public void print() {
        System.out.println("The Min Heap is ");
        for (int i = 0; i < this.size / 2; i++) {
            System.out.println("PARENT : " + this.heap[i]);

            System.out.println("--LEFT CHILD : " + this.heap[2 * i + 1]);

            System.out.println("--RIGHT CHILD : " + this.heap[2 * i + 2]);
            System.out.println();
        }
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        ArrayHeap test = new ArrayHeap(10);
        test.enqueue(5);
        test.enqueue(1);
        test.enqueue(4);
        test.enqueue(3);
        test.enqueue(2);
        test.print();
        System.out.println();
        
        test.dequeue();
        test.dequeue();
        test.print();
        System.out.println();
        
        test.dequeue();
        test.dequeue();
        test.print();
        System.out.println();
        
        test.dequeue();
        test.print();
        System.out.println();
        
        test.dequeue();
    }
}
