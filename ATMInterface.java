//Name: Chanaya Gayle
//Date: November 26, 2024
//Task: Codsoft ATM MachineTask #3

package atmMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); 
        ATM atm = new ATM(account);

        JFrame frame = new JFrame("ATM Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 1, 10, 10));

        JLabel welcomeLabel = new JLabel("Welcome to the ATM", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton exitButton = new JButton("Exit");

        Dimension buttonSize = new Dimension(150, 30);
        withdrawButton.setPreferredSize(buttonSize);
        depositButton.setPreferredSize(buttonSize);
        checkBalanceButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
                if (input != null && !input.trim().isEmpty()) {  // Check if input is not null and not empty
                    try {
                        double amount = Double.parseDouble(input);
                        atm.withdraw(amount);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter deposit amount:");
                if (input != null && !input.trim().isEmpty()) {  
                    try {
                        double amount = Double.parseDouble(input);
                        atm.deposit(amount);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                }
            }
        });


        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atm.checkBalance();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(welcomeLabel);
        frame.add(withdrawButton);
        frame.add(depositButton);
        frame.add(checkBalanceButton);
        frame.add(exitButton);

        frame.setVisible(true);
    }
}
