package priorityqueues;

import java.util.*;

/*
It turns out that an array is very well suited for implementing a heap. It
might be that this is the main reason for using a heap when implementing
a priority queue.
The trick we will use is that we can represent a binary tree in an array
in a quite effcient way if we organize it well. The rule is that a node at
position n will have its left and right branch at n * 2 + 1 and n * 2 + 2. The
root of the tree is always at position 0 so the left branch is at 1 and the
right branch at 2. The node at position 1 has the left branch at 3 and the
right branch at 4.
If the tree that we wan to represent have both short and long branches
the array representation will be very sparse i.e. there will be many positions
with a null value since the node that should be there does not exist. If the
tree is dense i.e. almost all nodes are there, then the array will be almost
completely filled up with nodes.
A complete tree is a tree where all levels are completely filled apart from
the lowest level of leafs. If the lowest level is filled from left to right the tree
becomes ideal to represent using an array. This is of course what we want
and it turns out that in a heap we can choose to construct the tree in this
way.
*/

public class ArrayHeap {
    private Integer[] heap;
    private int nodes; // Elements in the heap
    
    public ArrayHeap(int size) {
        this.heap = new Integer[size];
        this.nodes = 0;
    }
    
    /*
    Assume that we have a heap that is complete tree with the lowest level
    filled from left to right. The array that represents the tree will have all slots
    filled up to a position k. When we add an element we simply write this at
    position k + 1, the problem is of course that the tree might not fulfill the
    requirements of a heap any longer.
    The reason why the tree might not be a heap any more is that the newly
    added node could have a lower value compared to its parent node. If the new
    node has a higher value then all is fine but if not we have to do something
    about it.
    Assume that n is an even number, let's say 8. All even numbers have
    their parent node at (n - 2)/2. The node at 8 thus has its parent at 3. All
    odd nodes have their parent at (n - 1)/2 so the node at 3 has its parent at
    1 and the parent of 1 is a at 0. We can thus trace the nodes from the new
    leaf to the root of the tree.
    When we add a new value we identify the parent node and if the new
    value is lower we swap the values. The tree might still not be a heap so we
    repeat this process looking at the newly swapped node and its parent. We
    will either reach a node whose parent is not greater or the root of the tree
    and in both cases the tree is again a heap.
    */
    public void enqueue(Integer value) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException("Queue is full!");
        
        
        
        this.nodes++;
    }
    
    /*
    Removing an element is equally simple, we let a value sink down to its right
    position. The value that we should return is of course the value of the root
    node. We remove this value and replace it with the last value in the array
    (at k). The tree is now probably not a heap since we replaced the smallest
    element with an element that is found in a leaf.
    If we let this value sink i.e. be swapped with either the value of the left
    or right branch (swapping with the smallest). We will eventually come to a
    position where it's either a leaf or the branches below it have higher values.
    Note that if the last element was at position k before we did the remove
    operation, the last element is now found at k - 1.
    Increment a value is done by updating the root value then let it sink to
    its right position. 
    */
    public Integer dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty!");
        
        
        
        this.nodes--;
        return 0;
    }
    
    public boolean isEmpty() {
        return this.nodes == 0;
    }
    
    public boolean isFull() {
        return this.nodes == this.heap.length;
    }
    
    /**
     * Prints the contents of the queue.
     */
    public void print() {
        
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        ArrayHeap test = new ArrayHeap(5);
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
