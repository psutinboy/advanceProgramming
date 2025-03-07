package hospitalpackage;

public class Doctorclass {
    public String name = "Dr. John";
    protected String department = "Cardiology";
    String hospitalName = "City Hospital";

    public Doctorclass() {
        System.out.println("Doctor constructor called.");
    }

    public void showDoctorInfo() {
        System.out.println("Doctor Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Hospital Name: " + hospitalName);
    }
}
