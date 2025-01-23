
import java.util.Scanner;

public class Num {

    public static String checkNumber(int num) {
        // Using ternary operator to check if number is positive or negative
        return num == 0 ? "Zero" : (num > 0 ? "Positive" : "Negative");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println(number + " is " + checkNumber(number));

        scanner.close();
    }
}
