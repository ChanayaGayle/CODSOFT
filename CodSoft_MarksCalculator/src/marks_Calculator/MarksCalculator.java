//Name:Chanaya Gayle
//Date:November 19, 2024
//Codsoft Grade calculator 

package marks_Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarksCalculator {

    private String[] subjectNames = new String[5];
    private int[] marks = new int[5];
    private double averagePercentage;
    private String[] subjectGrades = new String[5];

    public void calculateResults() {
        int totalMarks = 0;

        for (int i = 0; i < 5; i++) {
            totalMarks += marks[i];

            // marks calculation
            double percentage = (marks[i] / 100.0) * 100;
            if (percentage >= 90) {
                subjectGrades[i] = "A+";
            } else if (percentage >= 80) {
                subjectGrades[i] = "A";
            } else if (percentage >= 70) {
                subjectGrades[i] = "B";
            } else if (percentage >= 60) {
                subjectGrades[i] = "C";
            } else {
                subjectGrades[i] = "F";
            }
        }

        // avg
        averagePercentage = (double) totalMarks / 5;
    }


    public void createAndShowGUI() {
        JFrame frame = new JFrame("Marks Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);

       
        frame.setLayout(new BorderLayout(10, 10)); 

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 10, 10)); 
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Subject Details"));  

        // Fields for subject names and marks
        JTextField[] subjectFields = new JTextField[5];
        JTextField[] marksFields = new JTextField[5];

        for (int i = 0; i < 5; i++) {
            inputPanel.add(new JLabel("Subject " + (i + 1) + ":"));
            subjectFields[i] = new JTextField(20);  
            inputPanel.add(subjectFields[i]);

            inputPanel.add(new JLabel("Marks (0-100):"));
            marksFields[i] = new JTextField(5);  
            inputPanel.add(marksFields[i]);
        }

        // Add input panel to the frame
        frame.add(inputPanel, BorderLayout.CENTER);

        // Button to calculate the results
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));
        calculateButton.setPreferredSize(new Dimension(200, 40)); 
        frame.add(calculateButton, BorderLayout.SOUTH);

        // Display results
        JTextArea resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(350, 150)); 
        frame.add(scrollPane, BorderLayout.NORTH);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validInput = true;

                // Get subject names and marks from the text fields and validate them
                for (int i = 0; i < 5; i++) {
                    subjectNames[i] = subjectFields[i].getText().trim();
                    try {
                        marks[i] = Integer.parseInt(marksFields[i].getText().trim());
                        if (marks[i] < 0 || marks[i] > 100) {
                            validInput = false;
                            JOptionPane.showMessageDialog(frame, "Error: Marks must be between 0 and 100 for Subject " + (i + 1));
                            break;
                        }
                    } catch (NumberFormatException ex) {
                        validInput = false;
                        JOptionPane.showMessageDialog(frame, "Error: Please enter a valid number for Subject " + (i + 1));
                        break;
                    }
                }

                if (validInput) {
                    calculateResults();

                    // Display the results in the text area
                    StringBuilder resultText = new StringBuilder();
                    for (int i = 0; i < 5; i++) {
                        double percentage = (marks[i] / 100.0) * 100;
                        resultText.append(subjectNames[i] + " - " + marks[i] + " Marks (" + String.format("%.2f", percentage) + "%) - Grade: " + subjectGrades[i] + "\n");
                    }
                    resultText.append("\nOverall Average: " + String.format("%.2f", averagePercentage) + "%");

                    resultArea.setText(resultText.toString());
                }
            }
        });

        frame.setVisible(true);
    }

}
