class PatientInfo {
  int patid, numday;
  void show1() {
    System.out.println("Patient ID & Number of days: " + patid + " " + numday);
  }
}
    
class Payment extends PatientInfo {
  int amount;
  void show2() {
    System.out.println("Amount per day: " + amount);
  }

  void sum() {
    System.out.println("Total amount: " + (numday * amount));
  }
}

class Tax extends Payment {
  int taxPer;
  void sum1() {
    double taxAmount = 0.5 * (numday * amount);
    System.out.println("Amount with tax: " + taxAmount);
  }
}

class Inheritance1 {
  public static void main(String[] args) {
    PatientInfo SuperObj = new PatientInfo();
    Payment SubObj1 = new Payment();
    Tax SubObj2 = new Tax();

    SuperObj.patid = 25;
    SuperObj.numday = 5;
    System.out.println("Contents of SuperObj: ");
    SuperObj.show1();
    System.out.println();

    SubObj1.patid = 5;
    SubObj1.numday = 3;
    SubObj1.amount = 100;
    System.out.println("Contents of SubObj1: ");
    SubObj1.show1();
    SubObj1.show2();
    System.out.println();
    System.out.println("Sum for SubObj1: ");
    SubObj1.sum();
  
    System.out.println("Contents of SubObj2: ");
    SubObj2.numday = 2;
    SubObj2.amount = 500;
    SubObj2.sum();
    SubObj2.sum1();
  }
}