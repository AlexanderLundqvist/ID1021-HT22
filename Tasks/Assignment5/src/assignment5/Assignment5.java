package assignment5;
import java.util.*;

/**
 * This class tests different implementations of linked lists.
 * 
 * @author Alexander Lundqvist
 */
public class Assignment5 {
    
    private static int[] unsortedArray(int size) {
            Random rand = new Random();
            int[] array = new int[size];
            for (int i = 0; i < size ; i++) {
                array[i] = rand.nextInt(size - 1);
            }
            return array;
    }
    
    private static Integer[] unsortedIntegers(int size) {
        Random rand = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size ; i++) {
                array[i] = new Integer(rand.nextInt(size - 1));
            }
        return array;
    }
    
    private static LinkedList generateList(int size) {
        Random rand = new Random();
        LinkedList list = new LinkedList();
        for(int i = 0; i < size; i++) {
            list.push(rand.nextInt(size - 1));
        }
        return list;
    }
    
    public static int[] append(int[] static_array, int[] array) {
        int[] new_array = new int[static_array.length + array.length];
        int index = 0;
        for(int i = 0; i < static_array.length; i++) {
            new_array[index++] = static_array[i];
        }
        for(int j = 0; j < array.length; j++) {
            new_array[j+index] = array[j];
        }
        return new_array;
    }
    
    public static Integer[] appendInteger(Integer[] static_array, Integer[] array) {
        Integer[] new_array = new Integer[static_array.length + array.length];
        int index = 0;
        for(int i = 0; i < static_array.length; i++) {
            new_array[index++] = static_array[i];
        }
        for(int j = 0; j < array.length; j++) {
            new_array[j+index] = array[j];
        }
        return new_array;
    }
    
    /**
     * Controls the program flow.
     * 
     * @param args takes no arguments
     */
    public static void main(String[] args) {
        int iterations = 1000;

//        System.out.println("Linked list");
//        int static_size = 100;
//        int size = 0;
//        int increment = 100;
//        for(int i = 0; i < 100; i++) {
//            long min = Long.MAX_VALUE;
//            size += increment;
//            for(int j = 0; j < iterations; j++) {
//                LinkedList static_list = generateList(static_size);
//                LinkedList list = generateList(size);
//                long t_start = System.nanoTime();
//                static_list.appendFirst(list);
//                long t = System.nanoTime() - t_start;
//                if (t < min) {
//                    min = t;
//                }
//            }
//            System.out.println(min);
//        }

//        System.out.println("Primitive arrays");
//        int static_size = 10;
//        int size = 0;
//        int increment = 100;
//        for(int i = 0; i < 100; i++) {
//            long min = Long.MAX_VALUE;
//            size += increment;
//            for(int j = 0; j < iterations; j++) {
//                int[] static_array = unsortedArray(static_size);
//                int[] array = unsortedArray(size);
//                long t_start = System.nanoTime();
//                int[] result = append(static_array, array);
//                long t = System.nanoTime() - t_start;
//                if (t < min) {
//                    min = t;
//                }
//            }
//            System.out.println(min);
//        }

        System.out.println("Integer arrays");
        int static_size = 10;
        int size = 0;
        int increment = 100;
        for(int i = 0; i < 100; i++) {
            long min = Long.MAX_VALUE;
            size += increment;
            for(int j = 0; j < iterations; j++) {
                Integer[] static_array = unsortedIntegers(static_size);
                Integer[] array = unsortedIntegers(size);
                long t_start = System.nanoTime();
                Integer[] result = appendInteger(static_array, array);
                long t = System.nanoTime() - t_start;
                if (t < min) {
                    min = t;
                }
            }
            System.out.println(min);
        }
        
    }
    
}
