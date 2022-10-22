package priorityqueues;

import java.util.*;

/**
 * This class represents a binary heap in a tree structure.
 * @author Adrian Jonsson
 * Re-implemented by Alexander Lundqvist
 */
public class TreeHeap { 
    Node root;

    private class Node {
        private Integer priority;
        private int size;
        private Node left;
        private Node right;

        public Node(int priority, int size) {
            this.priority = priority;
            this.size = size;
            this.left = this.right = null;
        }


        private int add(int prio, int depth) {
            if (this.priority == prio) {
                return depth;
            }
            // we want to move the item and prio of the current node down if the item we
            // want to add has lower priority than the node we're in
            if (prio < this.priority) {
                int tempPriority = this.priority;
                this.priority = prio;
                prio = tempPriority;
            }
            this.size++;
            if (this.left == null) {
                this.left = new Node(prio, 1);
                return depth;
            } else if (this.right == null) {
                this.right = new Node(prio, 1);
                return depth;
            } else if (this.right.size < this.left.size) {
                return this.right.add(prio, depth + 1);
            } else {
                return this.left.add(prio, depth + 1);
            }

        }

        private Node remove() {
            // if the left branch is empty we promote the right branch to root.
            if (this.left == null) {
                this.priority = this.right.priority;
                this.right = null;
                this.size--;
                return this;
            }
            // if the right branch is empty we promote the left branch to root
            if (this.right == null) {
                this.priority = this.left.priority;
                this.left = null;
                this.size--;
                return this;
            }
            if (this.left.priority < this.right.priority) {
                this.priority = this.left.priority;
                this.size--;
                if (this.left.size == 1) {
                    this.left = null;
                } else {
                    this.left = this.left.remove();
                }
                return this;
            } else {
                this.priority = this.right.priority;
                this.size--;
                if (this.right.size == 1) {
                    this.right = null;
                } else {
                    this.right = this.right.remove();
                }
            }
            return this;
        }
        
        // depth first traversal
        public void print() {
            if (left != null)
                left.print();
            System.out.println(priority);
            if (right != null)
                right.print();
        }
    }

    public TreeHeap() {
        root = null;
    }

    public int enqueue(int priority) {
        int depth = 0;
        if (root == null) {
            root = new Node(priority, 1);
        } else {
            depth = root.add(priority, 1);
        }
        return depth;
    }

    public void swapMinNodeUp(Node swapDown, Node swapUp) {

        int tempPriority = swapDown.priority;
        swapDown.priority = swapUp.priority;
        swapUp.priority = tempPriority;
    }

    public int push(int increment) {
        this.root.priority += increment;
        Node current = this.root;
        return push(this.root.priority, current, 0);

    }

    private int push(int newRootValue, Node current, int depth) {
        if (current.left == null) {
            if (newRootValue < current.right.priority) {
                return depth;
            } else if (current.left.priority < newRootValue) {
                depth++;
                swapMinNodeUp(current, current.right);

            }
            if (current.right.size != 1) {
                depth = push(newRootValue, current.right, depth);
            }
        }
        if (current.right == null) {
            if (current.left.priority > newRootValue) {
                return depth;
            } else if (current.left.priority < newRootValue) {
                depth++;
                swapMinNodeUp(current, current.left);
            }
            if (current.left.priority != 1) {
                depth = push(newRootValue, current.left, depth);
            }
        }
        if (current.left.priority > current.right.priority) {
            if (current.right.priority > newRootValue) {
                return depth;
            } else if (current.right.priority < newRootValue) {
                depth++;
                swapMinNodeUp(current, current.right);
            }
            if (current.right.size != 1) {
                depth = push(newRootValue, current.right, depth);
            }
        } else {
            if (current.left.priority > newRootValue) {
                return depth;
            } else if (current.left.priority < newRootValue) {
                depth++;
                swapMinNodeUp(current, current.left);
            }
            if (current.left.size != 1) {
                depth = push(newRootValue, current.left, depth);
            }
        }
        return depth;
    }

    public int dequeue() {
        if (root == null) {
            System.out.println("Heap is empty");
            return -1;
        } else if (root.left == null && root.right == null) {
            int oldRootToBeReturned = (int) this.root.priority;
            root = null;
            return oldRootToBeReturned;
        } else {
            int oldRootToBeReturned = (int) this.root.priority;
            root.remove();
            return oldRootToBeReturned;
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        root.print();
    }

    public static void main(String[] args) {
        TreeHeap test = new TreeHeap();
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
