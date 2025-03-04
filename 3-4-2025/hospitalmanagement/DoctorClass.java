package hospitalmanagement;

public class DoctorClass {
    public String name = "Dr. John";       // Public - accessible anywhere
    protected String department = "Cardiology";  // Protected - accessible in package and subclasses
    String hospitalName = "City Hospital";  // Default (package) - accessible in package
    private int doctorId = 12345;          // Private - accessible only in this class
    
    public DoctorClass() {
        System.out.println("Doctor constructor called.");
    }
    
    public void showDoctorInfo() {
        System.out.println("Doctor Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Doctor ID: " + doctorId);
    }
} 