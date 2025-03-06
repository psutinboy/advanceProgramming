package hospitalmanagement;

import hospitalpackage.Doctorclass;

public class HospitalManagement extends Doctorclass {

    public void accessDoctorDetails() {
        // Public member - accessible from any package
        System.out.println("Accessing Doctor's Name (public): " + name);

        // Protected member - accessible in subclass or same package
        System.out.println("Accessing Department (protected): " + department);

        // Default (package-private) member - NOT accessible outside the package
        // System.out.println("Accessing Hospital Name (default): " + hospitalName); //
        // This will cause an error

        // Private member - NOT accessible outside the class
        // System.out.println("Accessing Doctor ID (private): " + doctorId); // This
        // will cause an error
    }
}
