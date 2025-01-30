//create a class named Rectangle and create two objects and determine the area of the rectangle

class Rectangle {

    private int length;
    private int width;

    public Rectangle(int l, int w) {
        length = l;
        width = w;
    }

    public int getArea() {
        return length * width;
    }
}

public class RectangleArea {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(30, 40);
        System.out.println("Area of r1: " + r1.getArea());
        System.out.println("Area of r2: " + r2.getArea());
    }
}
