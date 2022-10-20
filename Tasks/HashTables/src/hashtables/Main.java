package hashtables;

import java.io.*;
import java.util.*;

public class Main {
    
    public static long benchmarkLinearString(int iterations, String areaCode) {
        Zip zip = new Zip();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.linearSearch(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static long benchmarkBinaryString(int iterations, String areaCode) {
        Zip zip = new Zip();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.linearSearch(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static long benchmarkLinearInteger(int iterations, Integer areaCode) {
        Zip zip = new Zip();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.linearSearch(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    public static long benchmarkBinaryInteger(int iterations, Integer areaCode) {
        Zip zip = new Zip();
        long t_min = Long.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            long t_start = System.nanoTime();
            zip.linearSearch(areaCode);
            long t_total = System.nanoTime() - t_start;
            if (t_total < t_min) {
                t_min = t_total;
            }
        }
        return t_min;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iterations  = 100;   
               
        System.out.println("Linear search string(111 15): " + benchmarkLinearString(iterations, "111 15"));
        System.out.println("Binary search string(984 99): " + benchmarkLinearString(iterations, "984 99"));
        System.out.println("Linear search string(111 15): " + benchmarkBinaryString(iterations, "111 15"));
        System.out.println("Binary search string(984 99): " + benchmarkBinaryString(iterations, "984 99"));
        System.out.println("Linear search integer(111 15): " + benchmarkLinearInteger(iterations, 11115));
        System.out.println("Binary search integer(984 99): " + benchmarkLinearInteger(iterations, 98499));
        System.out.println("Linear search integer(111 15): " + benchmarkBinaryInteger(iterations, 11115));
        System.out.println("Binary search integer(984 99): " + benchmarkBinaryInteger(iterations, 98499));
        
        

    }

}
