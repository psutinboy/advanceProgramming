interface Bank {
  float rateOfInterest();
}

class Chase implements Bank {
  @Override
  public float rateOfInterest() {
    return 9.15f;
  }
}

class WellsFargo implements Bank {
  @Override
  public float rateOfInterest() {
    return 9.7f;
  }
}

public class DemoInterface2 {
  public static void main(String[] args) {
    Bank chase = new Chase();
    Bank wellsFargo = new WellsFargo();
    
    System.out.println("Chase Bank Rate of Interest is: " + chase.rateOfInterest() + "%");
    System.out.println("Wells Fargo Rate of Interest is: " + wellsFargo.rateOfInterest() + "%");
  }
}
