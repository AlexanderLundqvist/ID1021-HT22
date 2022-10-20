package hashtables;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Zip {
    private Node[] data;
    private int max;
    
    public class Node {
        private String areaCodeString;
        private Integer areaCodeInt;
        private String name;
        private Integer population;
        
        public Node(String areaCode, String name, Integer population) {
            this.areaCodeString = areaCode;
            this.areaCodeInt = Integer.valueOf(areaCode.replaceAll("\\s+",""));
            this.name = name;
            this.population = population;
        }
    }
    
    public Zip() {
        String file = "postnummer.csv";
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean linearSearch(String areaCode) {
        int i = -1;
        for(i = 0; i < data.length; i++) {
            if(data[i].areaCodeString.equals(areaCode)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean binarySearch(String areaCode) {
        int lo = 0; 
        int hi = data.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if      (data[mid].areaCodeString.equals(areaCode))                                          return true;
            else if (Integer.valueOf(data[mid].areaCodeString) > Integer.valueOf(areaCode) && mid > lo) hi = mid - 1;
            else if (Integer.valueOf(data[mid].areaCodeString) < Integer.valueOf(areaCode) && mid < hi) lo = mid + 1;
            else return false;
        }
        return false;
    }
    
    public boolean linearSearch(Integer areaCode) {
        int i = -1;
        for(i = 0; i < data.length; i++) {
            if(data[i].areaCodeInt.compareTo(areaCode) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean binarySearch(Integer areaCode) {
        int lo = 0; 
        int hi = data.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if      (data[mid].areaCodeInt.compareTo(areaCode) == 0)            return true;
            else if (data[mid].areaCodeInt.compareTo(areaCode) > 0 && mid > lo) hi = mid - 1;
            else if (data[mid].areaCodeInt.compareTo(areaCode) < 0 && mid < hi) lo = mid + 1;
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
        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());
    }

}
