class BankAccount {
    private double balance = 1000.0;
    
    public synchronized void withdraw(double amount, String customerName) {
        System.out.println(customerName + " is trying to withdraw $" + amount);
        if (balance >= amount) {
            System.out.println(customerName + " is withdrawing $" + amount);
            balance -= amount;
            System.out.println(customerName + " withdrew successfully. Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient funds for " + customerName + ". Current balance: $" + balance);
        }
    }
    
    public double getBalance() {
        return balance;
    }
}

class CustomerThread extends Thread {
    private BankAccount account;
    private String customerName;
    
    public CustomerThread(BankAccount account, String customerName) {
        this.account = account;
        this.customerName = customerName;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            double withdrawAmount = 300.0;
            account.withdraw(withdrawAmount, customerName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadSynchronization {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        CustomerThread customer1 = new CustomerThread(account, "John");
        CustomerThread customer2 = new CustomerThread(account, "Jane");

        customer1.start();
        customer2.start();
    }
}
