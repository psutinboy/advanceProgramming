
import java.util.Scanner;

public class area {

    private double length;
    private double width;

    public area() {
        length = 0;
        width = 0;
    }

    public void setLength(double len) {
        length = len;
    }

    public void setWidth(double wid) {
        width = wid;
    }

    public double calculateArea() {
        return length * width;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            area rectangle = new area();

            System.out.print("Enter the length of the rectangle: ");
            double length = input.nextDouble();

            System.out.print("Enter the width of the rectangle: ");
            double width = input.nextDouble();

            rectangle.setLength(length);
            rectangle.setWidth(width);

            System.out.println("The area of the rectangle is: " + rectangle.calculateArea());
        }
    }
}
