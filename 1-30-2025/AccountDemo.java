
class Account {

    int accno;
    int balance;

    void SetData(int acno, int bal) {
        accno = acno;
        balance = bal;
    }

    void ShowData() {
        System.out.println("Account Number: " + accno);
        System.out.println("Balance: " + balance);
    }

    void Deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void Withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

public class AccountDemo {

    public static void main(String[] args) {
        Account c1 = new Account();
        Account c2 = new Account();
        Account c3 = new Account();
        c1.SetData(100, 1500);
        c2.SetData(101, 2500);
        c3.SetData(102, 3500);
        Account customer[] = new Account[3];

        customer[0] = c1;
        customer[1] = c2;
        customer[2] = c3;
        for (int i = 0; i < 3; i++) {
            customer[i].ShowData();
        }
        c1.ShowData();
        c2.ShowData();
        c3.ShowData();

        // Test deposit and withdraw
        c1.Deposit(500);
        c1.Withdraw(200);
    }
}
