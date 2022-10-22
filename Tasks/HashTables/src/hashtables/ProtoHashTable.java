package hashtables;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SimpleHashTable {
    private Node[] data;
    private int[] keys;
    private int mod;
    private int max;
    
    public SimpleHashTable(int mod) {
        String file = "postnummer.csv";
        this.mod = mod;
        this.data = new Node[mod];
        this.keys = new int[9675];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int areaCode = Integer.parseInt(row[0].replaceAll("\\s+", ""));
                this.keys[i++] = areaCode;
                insert(new Node(areaCode, row[1], Integer.valueOf(row[2])));
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
        
        public Node(Integer areaCode, String name, Integer population) {
            this.areaCode   = areaCode;
            this.name       = name;
            this.population = population;
        }
    }
    
    // Bad hashing function...
    private int hash(int key) {
        int hashed = key;
        hashed = hashed % this.mod;
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
        while(this.data[index] != null) index++;
        this.data[index] = node;        
    }
    
    
    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < this.max; i++) {
            int index = this.keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.println();
        System.out.println("Mod\t\tUnique\t\t2 keys\t\t3 keys\t\t4 keys");
        System.out.print(mod);
        for (int i = 0; i < 4; i++) {
            System.out.print("\t\t" + cols[i]);
        }
        System.out.println();
    }
    
    public String lookup(Integer areaCode) {
        int index = hash((int) areaCode);
        while (!this.data[index].areaCode.equals(areaCode)) {
            index++;
        }
        return this.data[index].name;          
    }
    
    /**
     * Main method with unit testing for the class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleHashTable hashTable = new SimpleHashTable(31327);
        hashTable.collisions(27773);
        hashTable.collisions(28627);
        hashTable.collisions(31327);
    }

}
