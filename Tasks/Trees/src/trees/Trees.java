package trees;

import java.util.*;

public class Trees {
    
    public static Integer[] generateIntegerArray(int size) {
        Integer[] array = new Integer[size];
        Random rand = new Random();
        for(int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size-1);
        }
        return array;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iterations  = 100000;
        BinaryTree bt   = new BinaryTree();
        BinarySearch bs = new BinarySearch();
        
        
        // Binary tree benchmark
//        int bt_size = 100;
//        for (int i = 0; i < 100; i++) {
//            Integer[] bt_array = generateIntegerArray(bt_size);
//            System.out.println(bt.benchmark(bt_size, iterations));
//            bt_size += 100;
//        }

        // Binary search benchmark
//        int bs_size = 100;
//        for (int i = 0; i < 100; i++) {
//            Integer[] bs_array = generateIntegerArray(bs_size);
//            System.out.println(bs.benchmark(bs_array, iterations));
//            bs_size += 100;
//        }

    }

}
