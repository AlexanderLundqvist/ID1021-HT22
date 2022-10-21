package hashtables;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Zip {
    private Node[] data;
    private int max;
    
    public class Node {
        public String areaCodeString;
        public Integer areaCodeInt;
        public String name;
        public Integer population;
        
        public Node(String areaCode, String name, Integer population) {
            this.areaCodeString = areaCode;
            this.areaCodeInt = Integer.valueOf(areaCode.replaceAll("\\s+",""));
            this.name = name;
            this.population = population;
        }
    }
    
    public Zip() {
        String file = "postnummer.csv";
        this.data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                this.data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            this.max = i-1;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean linearSearch(String areaCode) {
        for(int i = 0; i < this.data.length; i++) {
            if(this.data[i].areaCodeString.equals(areaCode)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean binarySearch(String areaCode) {
        int lo = 0; 
        //int hi = this.data.length - 1;
        int hi = max;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if      (this.data[mid].areaCodeString.equals(areaCode))                     return true;
            else if (this.data[mid].areaCodeString.compareTo(areaCode) > 0 && mid > lo) hi = mid - 1;
            else if (this.data[mid].areaCodeString.compareTo(areaCode) < 0 && mid < hi) lo = mid + 1;
            else return false;
        }
        return false;
    }
    
    public boolean linearSearch(Integer areaCode) {
        for(int i = 0; i < this.data.length; i++) {
            if(this.data[i].areaCodeInt.compareTo(areaCode) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean binarySearch(Integer areaCode) {
        int lo = 0; 
        //int hi = this.data.length - 1;
        int hi = max;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if      (this.data[mid].areaCodeInt.compareTo(areaCode) == 0)            return true;
            else if (this.data[mid].areaCodeInt.compareTo(areaCode) > 0 && mid > lo) hi = mid - 1;
            else if (this.data[mid].areaCodeInt.compareTo(areaCode) < 0 && mid < hi) lo = mid + 1;
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
        Zip test = new Zip();
        System.out.format("%-8s    %-12s   %-12s", "Code", "Location", "Population");
        System.out.println("\n-----------------------------------------");
        System.out.format("%-8s    %-12s   %-10s", test.data[0].areaCodeString, test.data[0].name, test.data[0].population);
        System.out.println();
        System.out.format("%-8s    %-12s   %-10s", test.data[9674].areaCodeString, test.data[9674].name, test.data[9674].population);
        System.out.println();
    }

}
