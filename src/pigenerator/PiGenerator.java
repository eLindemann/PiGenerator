package pigenerator;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Erik Lindemann <lindemannerik@gmail.com>
 */
public class PiGenerator {
    int numberOfTrials;
    int bound;
    Random generator;
    int coPrimes;
    boolean isVerbose;
    
    public PiGenerator(int numberOfTrials, int bound, boolean setVerbose) {
        this.numberOfTrials = numberOfTrials;
        this.bound = bound;
        this.generator = new Random();
        this.isVerbose = setVerbose;
        this.coPrimes = 0;
    }
    
    public void Run() {
        for (int i = 0; i < numberOfTrials; i++) {
            BigInteger firstRandom = BigInteger.valueOf(generator.nextInt(bound));
            if (isVerbose) System.out.println("firstRandom: " + firstRandom);
            BigInteger secondRandom = BigInteger.valueOf(generator.nextInt(bound));
            if (isVerbose) System.out.println("secondRandom: " + secondRandom);
            BigInteger greatestCommon = firstRandom.gcd(secondRandom);
            if (isVerbose) System.out.println("GCD: " + greatestCommon);
            
            if (greatestCommon.intValue() == 1) {
                coPrimes++;
            }
        }
        double probability = (double) coPrimes / numberOfTrials;
        double piEstimate = Math.sqrt(6.0/probability);
        System.out.println("Pi Estimate: " + piEstimate);
        System.out.println("Happy \u03c0 Day!");
    }
    
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        System.out.println("\u03c0 Estimator Tool!");
        System.out.println("------------------------------------------------------");
        System.out.println("The probability that two random numbers are coprime is 6/\u03c0\u00b2.");
        System.out.println("So with a set of random numbers, and a little math, we can calculate \u03c0.");
        System.out.println("------------------------------------------------------");
        System.out.print("How many trials: ");
        int trials = Integer.parseInt(reader.nextLine());
        System.out.print("Upper bound for randomization: " );
        int bound = Integer.parseInt(reader.nextLine());
        System.out.print("Verbose y/n ? " );
        boolean setVerbose = false;
        char verbosity = reader.nextLine().toLowerCase().charAt(0);
        if (verbosity == 'y') setVerbose = true;
        
        PiGenerator generatomatic = new PiGenerator(trials, bound, setVerbose);
        generatomatic.Run();       
        
    }
    
}
