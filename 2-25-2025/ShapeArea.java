class Shape {

    double calculateArea() {
        System.out.println("Area calculation method in Shape class");
        return 0.0;
    }

    void displayArea() {
        System.out.println("Area: " + calculateArea());
    }
}

class Rectangle extends Shape {

    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    void displayArea() {
        System.out.println("Area of Rectangle: " + calculateArea());
    }
}

class Circle extends Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    void displayArea() {
        System.out.println("Area of Circle: " + calculateArea());
    }
}

class Square extends Shape {

    double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    double calculateArea() {
        return side * side;
    }

    @Override
    void displayArea() {
        System.out.println("Area of Square: " + calculateArea());
    }
}

public class ShapeArea {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 4.0);
        Circle circle = new Circle(3.0);
        Square square = new Square(4.0);

        rectangle.displayArea();
        circle.displayArea();
        square.displayArea();

        System.out.println("\nDemonstrating dynamic method dispatch:");
        Shape shapeRef;

        shapeRef = rectangle;
        shapeRef.displayArea();

        shapeRef = circle;
        shapeRef.displayArea();

        shapeRef = square;
        shapeRef.displayArea();
    }
}
