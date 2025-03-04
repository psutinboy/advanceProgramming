package hospitalmanagement;

public class HospitalManagement extends DoctorClass {
    
    public void accessDoctorDetails() {
        System.out.println("Accessing Doctor's Name (public): " + name);

        System.out.println("Accessing Department (protected): " + department);
        
    }
} 