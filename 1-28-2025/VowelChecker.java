import java.util.Scanner;

public class VowelChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character to check if it's a vowel: ");

        if (!scanner.hasNext("[A-Za-z]")) {
            System.out.println("Error: Please enter a valid letter.");
            scanner.close();
            return;
        }

        char ch = scanner.next().toLowerCase().charAt(0);

        boolean isVowel = false;

        switch (ch) {
            case 'a', 'e', 'i', 'o', 'u' -> isVowel = true;
        }

        if (isVowel) {
            System.out.println(ch + " is a vowel");
        } else {
            System.out.println(ch + " is not a vowel");
        }

        scanner.close();
    }
}
