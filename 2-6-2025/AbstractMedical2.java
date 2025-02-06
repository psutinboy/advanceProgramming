//parent class
abstract class Patient {
 abstract void Patientinfo1();
 abstract void Patientinfo2();
}

//child class
class PatientDetails1 extends Patient {
    void Patientinfo1() {
        String P_name = "Hemanth";
        int P_age = 21;
        String P_location = "bangalore";

        System.out.println("Patient name: " + P_name);
        System.out.println("Patient age: " + P_age);
        System.out.println("Patient location: " + P_location);
    }

    void Patientinfo2() {
        String P_status = "good";
        int P_sugar = 110;
        int P_bp = 120;

        System.out.println("Patient status: " + P_status);
        System.out.println("Patient sugar level: " + P_sugar);
        System.out.println("Patient bp level: " + P_bp);
    }
}

//driver class
class AbstractMedical2 {
  //main fucntion
  public static void main(String[] args) {
    //object created
    PatientDetails1 P = new PatientDetails1();
    P.Patientinfo1();
    P.Patientinfo2();
  }
}