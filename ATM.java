//Name: Chanaya Gayle
//Date: November 26, 2024
//Task: Codsoft ATM MachineTask #3

package atmMachine;

import javax.swing.*;
import java.text.DecimalFormat;

public class ATM {
    private BankAccount account;
    private DecimalFormat df;

    public ATM(BankAccount account) {
        this.account = account;
        this.df = new DecimalFormat("#.00"); 
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.withdraw(amount);
            JOptionPane.showMessageDialog(null, "Withdrawal successful! New balance: " + df.format(account.getBalance()));
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            JOptionPane.showMessageDialog(null, "Deposit successful! New balance: " + df.format(account.getBalance()));
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Current balance: " + df.format(account.getBalance()));
    }
}

