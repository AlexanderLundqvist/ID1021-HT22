package introduction;

/*
run:

3600000000000
900000000000
225000000000
56250000000
14062500000
3515625000
878906250
219726562
54931640
13732910
3433227
858306
214576
53644
13411
3352
838
209
*/



public class Approximation {
    
    // Default constructor
    public Approximation() {
    }

    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
        // First find times to look for
//        System.out.println();
//        long time = 3600000000000L;
//        int count = 0;
//        while (time >= 100) {
//            System.out.println(time);
//            time /= 4;
//        }
        
        // Then approximate from 
        System.out.println();
        System.out.println("Calculate maxtime");
        long hour = 3600000000000L;
        long n = 4;
        long ns = 800;
        while (ns < hour) {
            if (ns*4 >= hour) break;
            else {
                ns *= 4;  
                n *= 2;
            }
        }
        System.out.println("n = " + n);
        System.out.println("ns = " + ns);
    }
}
