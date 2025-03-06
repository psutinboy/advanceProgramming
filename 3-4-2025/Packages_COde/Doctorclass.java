package hospitalpackage;

public class Doctorclass {
    public String name = "Dr. John"; // Public - accessible anywhere
    protected String department = "Cardiology"; // Protected - accessible in the same package or subclass
    String hospitalName = "City Hospital"; // Default (package-private) - accessible within the same package
    private int doctorId = 12345; // Private - only accessible within this class

    // Constructor
    public Doctorclass() {
        System.out.println("Doctor constructor called.");
    }

    // Method to display doctor details
    public void showDoctorInfo() {
        System.out.println("Doctor Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Doctor ID: " + doctorId);
    }
}
