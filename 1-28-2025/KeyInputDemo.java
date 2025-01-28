import java.util.Scanner;

public class KeyInputDemo {

    public static void main(String[] args) {
        int a;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        a = s.nextInt();
        System.out.println("You entered: " + a);
        s.close();
    }
}
