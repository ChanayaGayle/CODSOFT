//Name: Chanaya Gayle
//Date: Nov 30, 2024
//Task: Codsoft quiz. Task #4

package quizGame;

public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

