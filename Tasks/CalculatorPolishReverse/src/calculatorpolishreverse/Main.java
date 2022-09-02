package calculatorpolishreverse;

import java.util.Scanner;

/**
 * This program is a calculator which performs calculation on mathematical 
 * expressions using reverse polish notation. To accomplish this the program 
 * utilizes the stack data structure.
 * 
 * @author Alexander Lundqvist
 */
public class Main {
    
    public static Item[] generateExpression(int size) {
        Item[] expression = new Item[size];
        for (int i = 0; i <= size/2; i++)
            expression[i] = new Item(1); 
        for (int j = size/2 + 1; j < size; j++)
            expression[j] = new Item(ItemType.ADD);
        return expression;
    }
    
    /**
     * Controls the flow of the program.
     * @param args the command line arguments takes no arguments
     */
    public static void main(String[] args) {
        // Testing operations
        Item[] testBasic = new Item[7];
        testBasic[0] = new Item(10);
        testBasic[1] = new Item(2);
        testBasic[2] = new Item(ItemType.ADD);
        testBasic[3] = new Item(4);
        testBasic[4] = new Item(6);
        testBasic[5] = new Item(ItemType.DIV);
        testBasic[6] = new Item(ItemType.MUL);
        StaticCalculator evaluateBasicStatic = new StaticCalculator(testBasic);
        System.out.println("Basic static: " + evaluateBasicStatic.run()); // Should evaluate to 8
        DynamicCalculator evaluateBasicDynamic = new DynamicCalculator(testBasic);
        System.out.println("Basic dynamic: " + evaluateBasicDynamic.run()); // Should evaluate to 8
        
        Item[] testMod = new Item[2];
        testMod[0] = new Item(12);
        testMod[1] = new Item(ItemType.MOD);
        StaticCalculator evaluateModStatic = new StaticCalculator(testMod);
        System.out.println("Mod static: " + evaluateModStatic.run()); // Should evaluate to 2
        DynamicCalculator evaluateModDynamic = new DynamicCalculator(testMod);
        System.out.println("Mod dynamic: " + evaluateModDynamic.run()); // Should evaluate to 2
        
        Item[] testSpec = new Item[3];
        testSpec[0] = new Item(6);
        testSpec[1] = new Item(2);
        testSpec[2] = new Item(ItemType.MULX);
        StaticCalculator evaluateSpecStatic = new StaticCalculator(testSpec);
        System.out.println("Spec static: " + evaluateSpecStatic.run()); // Should evaluate to 3
        DynamicCalculator evaluateSpecDynamic = new DynamicCalculator(testSpec);
        System.out.println("Spec dynamic: " + evaluateSpecDynamic.run()); // Should evaluate to 3

        
        // Testing with generated expression to benchmark        
        Scanner input = new Scanner(System.in);
        System.out.println("Please input desired size of expression: ");
        int size = input.nextInt();
        Item[] generatedExpression = generateExpression(size);
        System.out.println();
        System.out.println();
        
        StaticCalculator benchmarkStatic = new StaticCalculator(generatedExpression);
        Long ts0 = System.nanoTime();
         System.out.println(benchmarkStatic.run());
        Long ts1 = System.nanoTime();
        Long ts_total = (ts1 - ts0);
        System.out.println("Static time for expression of size " + size + " is: " + ts_total + "ns");
        System.out.println();
        
        DynamicCalculator benchmarkDynamic = new DynamicCalculator(generatedExpression);
        Long td0 = System.nanoTime();
        System.out.println(benchmarkDynamic.run());
        Long td1 = System.nanoTime();
        Long td_total = (td1 - td0);
        System.out.println("Dynamic time for expression of size " + size + " is: " + td_total + "ns");
        System.out.println();
        
        // Evaluate personal number
        System.out.println("Calculating last digit of personal number");
        Item[] lastDigit = new Item[50];
        
        lastDigit[0] = new Item(9);
        lastDigit[1] = new Item(2);
        
        lastDigit[2] = new Item(2);
        lastDigit[3] = new Item(1);
        
        lastDigit[4] = new Item(0);
        lastDigit[5] = new Item(2);
        
        lastDigit[6] = new Item(0);
        lastDigit[7] = new Item(7);
        
        lastDigit[8] = new Item(9);
        lastDigit[8] = new Item(9);
        
        lastDigit[8] = new Item(9);
        lastDigit[8] = new Item(9);
        
        
        
        lastDigit[1] = new Item(ItemType.MOD);
        StaticCalculator calculateDigit = new StaticCalculator(lastDigit);
        System.out.println(calculateDigit.run());
    } 
}
