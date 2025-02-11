class Area {
  int length;
  int breadth;

  Area(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public void getArea() {
    int area = length * breadth;
    System.out.println("Area: " + area);
  }
}

public class Main {
  public static void main(String[] args) {
    Area rectangle = new Area(3, 4);
    rectangle.getArea();
  }
}
