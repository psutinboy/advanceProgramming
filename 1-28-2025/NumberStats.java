
import java.util.Scanner;

public class NumberStats {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to process: ");
        int n = scanner.nextInt();

        double[] numbers = new double[n];
        double sum = 0;

        // Get n numbers from user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];
        }

        // Calculate average
        double average = sum / n;

        // Display results
        System.out.println("\nResults:");
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);

        scanner.close();
    }
}
