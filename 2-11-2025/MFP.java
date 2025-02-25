import java.time.LocalDate;
import java.util.Scanner;

public class MFP {
    
    public static LocalDate calculateDate(int ordinalDay, LocalDate baseDate) {
        return baseDate.plusDays(ordinalDay - 1);
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get base date input from user
            System.out.println("Enter base date (format: DD MM YYYY):");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            LocalDate baseDate = LocalDate.of(year, month, day);
            
            // Get ordinal day input from user
            System.out.println("Enter ordinal day:");
            int ordinalDay = scanner.nextInt();
            
            // Calculate the corresponding date
            LocalDate resultDate = calculateDate(ordinalDay, baseDate);
            
            // Print the result
            System.out.println("The calculated date is: " + resultDate);
        }
    }
}
