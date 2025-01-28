
import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms for Fibonacci series: ");
        int n = scanner.nextInt();

        // Initialize first two numbers of Fibonacci series
        long firstTerm = 0;
        long secondTerm = 1;

        System.out.println("\nFibonacci Series for " + n + " terms:");

        // Handle first two terms separately
        if (n >= 1) {
            System.out.print(firstTerm);
        }
        if (n >= 2) {
            System.out.print(", " + secondTerm);
        }

        // Generate the remaining terms
        for (int i = 3; i <= n; i++) {
            long nextTerm = firstTerm + secondTerm;
            System.out.print(", " + nextTerm);

            // Update terms for next iteration
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }

        System.out.println(); // New line at the end
        scanner.close();
    }
}
