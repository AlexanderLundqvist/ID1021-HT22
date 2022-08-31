package introduction;

import java.util.*;

/**
 * This class contains several code snippets that aim to measure how the 
 * execution time changes when accessing array elements, looking up a particular 
 * element, looking for duplicates and what happens when the array size increases.
 * 
 * @author Alexander
 */
public class Introduction {
    
    /* 
    Task 1
    Now for the experiment, set up a benchmark where you call the
    access function with a larger and larger n. Present your conclusions in a
    nice table and pay attention to the number of signifcant figures that you
    use. 
    */
    private static double arrayAccess(int n) {
        
        int k = 1000000;
        Random rand = new Random();
        
        int[] index = new int[n];
        // filling the index with random number from 0 to n (not including n)
        for (int a = 0; a < n; a++) {
            index[a] = rand.nextInt(n);
        }
        
        int[] dummyArray = new int[n];
        // filling the dummyArray with value 1
        for (int d = 0; d < n; d++) {
            dummyArray[d] = n;
        }
        
        int sum = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                    // access the dummyArray with the index given by index[i]
                    // sum up the result
                    sum += dummyArray[index[j]];
                }
        }
        
        long t_access = (System.nanoTime() - t0);
        
        t0 = System.nanoTime();
        int sumDummy = 0;
        // do the same loop iteration but only do a dummy add operation
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                    sumDummy += 1;
                }
        }
        
        long t_dummy = (System.nanoTime() - t0);
        
        return ((double)(t_access - t_dummy))/((double)k*(double)n);
        
    }
    
    /* 
    Task 2
    You now have to choose rounds (number of rounds) and searches (number
    of search operation in each round) to something that gives you predictable
    results. You then do the benchmark for a growing size of the dummyArray n and
    examine the result. Find a polynomial that roughly describes the execution
    time as a function of n.
    */
    private static double arraySearch(int n) {
        int rounds = 1000; // k
        int searches = 10000; // m
        
        Random rand = new Random();
        
        int[] keys = new int[searches];
        int[] array = new int[n];   
        
        long t_total = 0;
        int sum = 0;
        for (int i = 0; i < rounds; i++) {
            // fill the keys array with random number from 0 to 10*n
            for (int k = 0; k < searches; k++) {
                keys[k] = rand.nextInt(10*n);
            }
            // fill the array with with random number from 0 to 10*n
            for (int a = 0; a < n; a++) {
                array[a] = rand.nextInt(10*n);
            }
            
            long t0 = System.nanoTime();
            for (int ki = 0; ki < searches; ki++) {
                int key = keys[ki];           
                for (int j = 0; j < n ; j++) {
                    if (array[j] == key) {
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        return ((double)t_total/((double)rounds*(double)searches));
    }
    
    /* 
    Task 3
    So now for the final task, finding duplicates in two arrays of length n. This
    task is very similar to the search exercise but now we have one dummyArray given
    that will work as the keys that we search for in the second dummyArray.
    Do as before an run the benchmark for a growing size of the arrays,
    n. Find a simple polynomial that roughly describes the execution time.
    Estimate how large n you would be able to handle if you had an hour of
    computation time.
    */
    private static double duplicates(int n) {
        
        Random rand = new Random();
        
        int[] keys = new int[n];
        int[] array = new int[n];   
        
        // fill the keys array with random number from 0 to n
        for (int k = 0; k < n; k++) {
            keys[k] = rand.nextInt(n);
        }
        // fill the array with with random number from 0 to n
        for (int a = 0; a < n; a++) {
            array[a] = rand.nextInt(n);
        }
        
        long t_total = 0;
        int sum = 0;
        
        long t0 = System.nanoTime();
        for (int ki = 0; ki < n; ki++) {
            int key = keys[ki];           
            for (int j = 0; j < n ; j++) {
                if (array[j] == key) {
                    sum++;
                    break;
                }
            }
        }
        t_total += (System.nanoTime() - t0);
        
        return ((double)t_total/((double)n*(double)n));
    }
    
    public static void main(String[] args) {
        
        // Task 1
//        System.out.println("Task 1");
//        int a = 200;
//        double test = arrayAccess(a); // To prevent faulty value 
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arrayAccess(a));
//            a += 200;
//        } 
//        System.out.println();
       
    
        // Task 2
//        System.out.println("Task 2");
//        int b = 100;
//        double test2 = arraySearch(b); // To prevent faulty value
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arraySearch(b));
//            b += 100;
//        }
//        System.out.println();
        
        
        // Task 3
        System.out.println("Task 3");
        int c = 100;
        double test3 = duplicates(c); // To prevent faulty value
        for (int i = 0; i < 10; i++) {
            System.out.println(arraySearch(c));
            c += 100;
        }
        System.out.println();
    } 
}
