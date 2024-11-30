//Name: Chanaya Gayle
//Date: Nov 30, 2024
//Task: Codsoft quiz. Task #4


package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int score;
    private int currentQuestionIndex;
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton submitButton;
    private JLabel timerLabel;
    private JProgressBar progressBar;
    private Timer swingTimer;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.currentQuestionIndex = 0;
        initializeGUI();
    }

    //gui implementation
    private void initializeGUI() {
        frame = new JFrame("SpongeBob Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        progressBar = new JProgressBar(0, questions.size());
        progressBar.setValue(0);
        topPanel.add(progressBar, BorderLayout.NORTH);

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        topPanel.add(questionLabel, BorderLayout.CENTER);

        frame.add(topPanel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        frame.add(optionsPanel, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        frame.add(submitButton, BorderLayout.SOUTH);

        timerLabel = new JLabel("Time left: 10 seconds", SwingConstants.CENTER);
        frame.add(timerLabel, BorderLayout.EAST);

        displayQuestion(questions.get(currentQuestionIndex));
        frame.setVisible(true);
    }

    private void displayQuestion(Question question) {
        questionLabel.setText(question.getQuestionText());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            optionButtons[i].setText(options[i]);
            optionButtons[i].setEnabled(true);  // Enable options for the new question
        }
        optionsGroup.clearSelection();
        frame.revalidate();
        frame.repaint();
        startTimer();
    }

    void startTimer() {
        if (swingTimer != null && swingTimer.isRunning()) {
            swingTimer.stop();
        }
        swingTimer = new Timer(1000, new ActionListener() {
            int timeLeft = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timerLabel.setText("Time left: " + timeLeft + " seconds");
                    timeLeft--;
                } else {
                    timerLabel.setText("Time's up!");
                    swingTimer.stop();
                    for (JRadioButton button : optionButtons) {
                        button.setEnabled(false);  // Disable options when time is up
                    }
                    moveToNextQuestion();  // Automatically move to the next question
                }
            }
        });
        swingTimer.start();
    }

    private void stopTimer() {
        if (swingTimer != null) {
            swingTimer.stop();
        }
    }

    private void moveToNextQuestion() {
        currentQuestionIndex++;
        progressBar.setValue(currentQuestionIndex);
        if (currentQuestionIndex < questions.size()) {
            displayQuestion(questions.get(currentQuestionIndex));
        } else {
            displayResult();
        }
    }

    private void displayResult() {
        JOptionPane.showMessageDialog(frame, "Your final score is: " + score + "/" + questions.size());
        frame.dispose();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                stopTimer();
                boolean answered = false;
                for (int i = 0; i < optionButtons.length; i++) {
                    if (optionButtons[i].isSelected()) {
                        answered = true;
                        if (i == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                            score++;
                        }
                    }
                }
                if (!answered) {
                    showError("Please select an answer."); //error handling
                    return;
                }
                moveToNextQuestion();
            } catch (Exception ex) {
                showError("An unexpected error occurred: " + ex.getMessage());
            }
        }
    }
}