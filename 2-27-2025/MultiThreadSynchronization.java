
public class MultiThreadSynchronization {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        CustomerThread customer1 = new CustomerThread(account, "John");
        CustomerThread customer2 = new CustomerThread(account, "Jane");

        customer1.start();
        customer2.start();
    }
}
