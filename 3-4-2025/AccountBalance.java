class Balance {
  String name;
  double bal;

  Balance(String n, double b) {
    name = n;
    bal = b;
  }
  void show() {
    if (bal < 0) {
      System.out.println(name + ": $" + bal);
    }
  }
}
  
public class AccountBalance {
  public static void main(String[] args) {
    Balance current[] = new Balance[3];

    current[0] = new Balance("Smith", 120.5);
    current[1] = new Balance("David", 157.10);
    current[2] = new Balance("Tom", 95.5);

    for (int i = 0; i < 3; i++) {
      current[i].show();
    }
  }
}