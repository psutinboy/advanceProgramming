package hospitalmanagement;

import hospitalpackage.Doctorclass;

public class HospitalManagement extends Doctorclass {

    public void accessDoctorDetails() {
        System.out.println("Accessing Doctor's Name (public): " + name);

        System.out.println("Accessing Department (protected): " + department);
    }
}
