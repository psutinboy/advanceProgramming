
public class DemoFinallyBlock1 {

    public static void main(String[] args) {
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (ArithmeticException e) {
            System.out.println("Message: " + e);
        } finally {
            System.out.println("Finally block is always executed");
        }
        System.out.println("Rest of code");
    }
}
