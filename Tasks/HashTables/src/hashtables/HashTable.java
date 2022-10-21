package hashtables;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HashTable {
    private Node[] data;
    private int[] keys;
    private int mod;
    private int max;
    
    public HashTable(int mod) {
        String file = "postnummer.csv";
        this.mod = mod;
        this.data = new Node[mod];
        this.keys = new int[9675];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int areaCode = Integer.parseInt(row[0].replaceAll("\\s", ""));
                this.keys[i++] = areaCode;
                insert(new Node(Integer.valueOf(row[0].replaceAll("\\s+","")), row[1], Integer.valueOf(row[2])));
            }
            this.max = i-1;
        } catch (Exception e) {
            System.out.println("Constructor Error: " + e);
        }
    }
    
    public class Node {
        public Integer  areaCode;       // Key (Unique)
        public String   name;           // Value
        public Integer  population;     // Value
        public Node     next, prev;
        
        public Node(Integer areaCode, String name, Integer population) {
            this.areaCode   = areaCode;
            this.name       = name;
            this.population = population;
            this.next = this.prev = null;
        }
    }
    
    // Bad hashing function...
    private int hash(int key) {
        int hashed = key % this.mod;
        return hashed;
    }
    
    /*
    // Better hashing function!
    private int hash(int key) {
        result = 31 * result + c
    }
    */
    
    public void insert(Node node) {
        int index = hash((int) node.areaCode);
        if(data[index] != null) {
            node.next = data[index];
            data[index].prev = node;
        }
        else this.data[index] = node;        
    }
    
    /*
    How many element you need to look at before finding the one that you're 
    looking for. Try with an increasing size of the array and compare the 
    results with the original solution.
    */
    public String lookup(Integer areaCode) {
        int index = hash((int) areaCode);
        Node current = this.data[index];
        while (current != null) {
            if (areaCode.equals(current.areaCode))
                return current.name;
            current = current.next;
        }
        return null;
    }
    
     public void countStepsInLookup() {
        int steps = 0;
        int max = 0;
        double average = 0;
        double numberOfTimesWeNeedToStep = 0;
        for (int i = 0; i < this.keys.length; i++) {
            int code = this.keys[i];
            int index = hash(this.keys[i]);
            steps = 0;
            while (!this.data[index].areaCode.equals(code)) {
                index++;
                steps++;
                average++;
            }
            if (steps > 0) {
                System.out.println("for code " + code + ", steps = " + steps);
                numberOfTimesWeNeedToStep++;
            }
            if (steps > max) {
                max = steps;
            }
        }
        System.out.println("max steps was: " + max);
        System.out.println("average steps was " + average / numberOfTimesWeNeedToStep);
        System.out.println("average number of times we needed to step was " + average / this.keys.length);
        System.out.println("number of times we needed to step " + numberOfTimesWeNeedToStep);
    }
    
    /**
     * Main method with unit testing for the class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable test = new HashTable(31327);
        test.countStepsInLookup();
    }

}
