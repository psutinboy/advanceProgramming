interface Drawable {
  void draw();
  default void msg() {
    System.out.println("default method");
  }
}

class Rectangle implements Drawable {
  @Override
  public void draw() {
    System.out.println("drawing rectangle");
  }
}

public class DemoInterfaceDefault {
  public static void main(String[] args) {
    Drawable d = new Rectangle();
    d.draw();
    d.msg();
  }
}
