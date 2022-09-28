package trees;

import java.util.*;

public class Trees {
    private static Random rand = new Random();
    
    
    /**
     * Generates a random uppercase letter string of chosen size.
     * 
     * @param stringLength the string length
     * @return the string
     */
    public static String generateRandomLetters(int stringLength) {
        int firstUppercaseIndex = 'A'; // for uppercase
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            int letterIndex = rand.nextInt(26);
            char randomUppercase = (char) (firstUppercaseIndex + letterIndex);
            stringBuilder.append(randomUppercase);
        }
        return stringBuilder.toString();
    }
    
    /**
     * Generates an array with randomly generated uppercase letter strings.
     * 
     * @param size the array size
     * @param stringLength the string length
     * @return the array
     */
    public static String[] generateRandomLettersArray(int size, int stringLength) {
        String[] values = new String[size];
        for(int i = 0; i < size; i++) {
            values[i] = generateRandomLetters(stringLength);
        }
        return values;
    }
    
    /**
     * Generates a random key bound by chosen size.
     * 
     * @param size the max value
     * @return the key
     */
    public static Integer generateRandomKey(int size) {
        return rand.nextInt(size-1);
    }
    
    /**
     * Generates an array with random keys of chosen size.
     * 
     * @param size the array size and maximum size of key
     * @return the array
     */
    public static Integer[] generateRandomKeyArray(int size) {
        Integer[] keys = new Integer[size];
        for(int i = 0; i < size; i++) {
            keys[i] = generateRandomKey(size);
        }
        return keys;
    }
    
    
//    public static Long benchmarkBT(int treeSize, int stringLength, int iterations) {     
//        // Create new tree and populate it
//        BinaryTree bt = new BinaryTree();
//        for(int i = 0; i < treeSize; i++) {
//            bt.put(generateRandomKey(treeSize), generateRandomLetters(stringLength));
//        }
//        
//        // Measure time it takes to search for a random key value pair
//        long min = Long.MAX_VALUE;
//        for(int i = 0; i < iterations; i++) {
//            long startTime = System.nanoTime();
//            bt.get(rand.nextInt(treeSize - 1));
//            long totalTime = System.nanoTime() - startTime;
//            if (totalTime < min) {
//                min = totalTime;
//            }
//        }
//        return min;
//    }
    
    public static Long benchmarkBT(int treeSize, int stringLength, int iterations) {     
        // Create new tree and populate it
        BinaryTree bt = new BinaryTree();
        Integer[] keys = generateRandomKeyArray(treeSize);
        String[] values = generateRandomLettersArray(treeSize, stringLength);
        for(int i = 0; i < treeSize; i++) {
            bt.put(keys[i], values[i]);
        }
        
        // Measure time it takes to search for a random key value pair
        long totalTime = 0;
        for(int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            bt.get(keys[rand.nextInt(treeSize - 1)]);
            totalTime += System.nanoTime() - startTime; 
        }
        return (totalTime/iterations);
    }
    
    /**
     * Controls the flow of the program.
     * @param args the command line arguments takes no arguments
     */
    public static void main(String[] args) {
        int iterations  = 100000;
        //BinarySearch bs = new BinarySearch();
        System.out.println(generateRandomLetters(3));
        
        // Binary tree benchmark
        int stringLength = 3;
        int treeSize = 100;
        for (int i = 0; i < 300; i++) {
            System.out.println(benchmarkBT(treeSize, stringLength, iterations));
            treeSize += 100;
        }

        // Binary search benchmark
//        int bs_size = 100;
//        for (int i = 0; i < 100; i++) {
//            Integer[] bs_array = generateIntegerArray(bs_size);
//            System.out.println(bs.benchmark(bs_array, iterations));
//            bs_size += 100;
//        }
          
    }

}
