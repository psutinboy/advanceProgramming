public class Member {

    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;
    private double salary;

    public Member(String name, int age, String phone, String address, String email, String password, double salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println("Salary: " + salary);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    // Add getters for private fields
    protected String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected String getAddress() {
        return address;
    }
}

class Employee extends Member {
    private String specialization;

    public Employee(String name, int age, String phone, String address, String email, String password, String specialization, double salary) {
        super(name, age, phone, address, email, password, salary);
        this.specialization = specialization;
    }

    public void printDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Specialization: " + specialization);
        printSalary();
    }
}

class Manager extends Member {
    private String department;

    public Manager(String name, int age, String phone, String address, String email, String password, String department, double salary) {
        super(name, age, phone, address, email, password, salary);
        this.department = department;
    }

    public void printDetails() {
        System.out.println("Manager Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Department: " + department);
        printSalary();
    }
}
