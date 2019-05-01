
/**
 *
 * @author NikkiNguyen
 */
import java.util.*;
import java.text.DecimalFormat;
//import java.lang.Math;

public class PrimalRage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getPrime();
    }

    public static void getPrime() {
        Scanner input = new Scanner(System.in);
        int N;

        do {
            System.out.println("How long should we search for primes? Until N: ");
            N = input.nextInt();
            if (N <= 2) {
                System.out.println("");
                System.out.println("N must be an integer greater than 2");
                System.out.println("");
            }
        } while (N <= 2);
        // initially all false, so change to true
        boolean[] isPrime = new boolean[N - 1];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        //sieve part
        for (int k = 2; k < isPrime.length + 2; k++) {
            if (isPrime[k - 2]) {
                //System.out.println(k);
                //mark as not prime
                for (int j = k * 2; j < isPrime.length + 2; j += k) {
                    isPrime[j - 2] = false;
                }

            }
        }

        //boolean[] primes = new boolean[N-1];
        for (int i = 0; i <= N; i++) {
            System.out.println("What number should we test for primeness? 0 to quit:");
            int x = input.nextInt();
            while (x == 1 || x < 0 || x > N) {
                System.out.println("Enter a number greater than 1 but less than " + (N + 1) + " (0 to quit): ");
                x = input.nextInt();
            }

            if (x == 0) {
                break;
            }

            if (isPrime[x-2]) {
                System.out.println(x + " IS a prime number!");
            } else if (isPrime[x-2] == false) {
                System.out.println(x + " IS NOT a prime number!");
            }
            //find mersenne prime
            double m = (Math.log(x + 1) / Math.log(2));
            DecimalFormat number = new DecimalFormat("#");
            if (m % 1 == 0 && isPrime[x-2]) {
                System.out.println(x + " is a Mersenne Prime! It is equal to 2^" + number.format(m) + " - 1");
            }
        }
    }

}
