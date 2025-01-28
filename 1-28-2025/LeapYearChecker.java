
import java.util.Scanner;

public class LeapYearChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year to check if it's a leap year: ");
        int year = scanner.nextInt();

        boolean isLeapYear = false;

        // Check if it's a leap year
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                // Check for century year
                if (year % 400 == 0) {
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }
        } else {
            isLeapYear = false;
        }

        // Display the result
        if (isLeapYear) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }

        scanner.close();
    }
}
