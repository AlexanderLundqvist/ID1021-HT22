package hashtables;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ZipKeyArray {
    private Node[] data;
    
    public ZipKeyArray() {
        String file = "postnummer.csv";
        this.data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int index = Integer.valueOf(row[0].replaceAll("\\s+",""));
                this.data[index] = new Node(Integer.valueOf(row[0].replaceAll("\\s+","")), row[1], Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public class Node {
        public Integer areaCode; // Key
        public String name;
        public Integer population;
        
        public Node(Integer areaCode, String name, Integer population) {
            this.areaCode = areaCode;
            this.name = name;
            this.population = population;
        }
    }
    
    public boolean lookup(Integer areaCode) {
        if(this.data[areaCode] != null) return true;
        else return false;
    }
    
    // Not working, need to fix for null values
    public boolean binarySearch(Integer areaCode) {
        int lo = 0; 
        int hi = this.data.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if      (this.data[mid].areaCode.compareTo(areaCode) == 0)            return true;
            else if (this.data[mid].areaCode.compareTo(areaCode) > 0 && mid > lo) hi = mid - 1;
            else if (this.data[mid].areaCode.compareTo(areaCode) < 0 && mid < hi) lo = mid + 1;
            else return false;
        }
        return false;
    }
    
    /**
     * Main method with unit testing for the class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Unit tests go here
    }

}
