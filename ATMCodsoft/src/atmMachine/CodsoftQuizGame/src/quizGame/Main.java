//Name: Chanaya Gayle
//Date: Nov 30, 2024
//Task: Codsoft quiz. Task #4


package quizGame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        //question and options
        questions.add(new Question("What instrument does Squidward play?", new String[]{"Drums", "Violin", "Clarinet", "Guitar"}, 2));
        questions.add(new Question("Where does SpongeBob live?", new String[]{"In a tree", "In a pineapple", "Under a rock", "In a boat"}, 1));
        questions.add(new Question("What is the name of SpongeBob's pet snail?", new String[]{"Larry", "Barry", "Gary", "Harry"}, 2));
        questions.add(new Question("What is Plankton constantly trying to steal?", new String[]{"Money", "The Krabby Patty secret formula", "Customers", "Jewels"}, 1));
        questions.add(new Question("What is the signature dish at the Krusty Krab?", new String[]{"Krabby Patty", "McKrab", "Double Krabber", "The Krab"}, 0));
        questions.add(new Question("Who runs the boating school that SpongeBob attends?", new String[]{"Mrs. Powers", "Mrs. Palmer", "Mrs. Puff", "Pearl"}, 2));
        questions.add(new Question("What type of animal is Pearl, Mr. Krabs's daughter?", new String[]{"Crab", "Sponge", "Whale", "Shark"}, 2));
        questions.add(new Question("Where does Sandy Cheeks hail from?", new String[]{"New York", "London", "Texas", "Los Angeles"}, 2));
        questions.add(new Question("What is the name of SpongeBob's favorite amusement park?", new String[]{"The Twirling Krab", "Disney World", "Glove World", "Jelly World"}, 2));
        questions.add(new Question("What is SpongeBob's favorite net-based hobby?", new String[]{"Tennis", "Jellyfishing", "Basketball", "Soccer"}, 1));

        Quiz quiz = new Quiz(questions);
        quiz.startTimer(); //start timer after the question is dispalyed
    }
}                           