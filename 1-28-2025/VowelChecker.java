
import java.util.Scanner;

public class VowelChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character to check if it's a vowel: ");
        char ch = scanner.next().toLowerCase().charAt(0);

        boolean isVowel = false;

        // Using switch statement to check for vowels
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                isVowel = true;
                break;
            default:
                isVowel = false;
        }

        // Display result
        if (isVowel) {
            System.out.println(ch + " is a vowel");
        } else {
            System.out.println(ch + " is not a vowel");
        }

        scanner.close();
    }
}
