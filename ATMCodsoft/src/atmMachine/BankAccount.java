//Name: Chanaya Gayle
//Date: November 26, 2024
//Task: Codsoft ATM MachineTask #3

package atmMachine;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
