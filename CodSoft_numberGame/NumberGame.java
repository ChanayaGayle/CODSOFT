//name: Chanaya Gayle
//Date November 10, 2004
//Codsoft number guessing game task

package numberGame;

//imports
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        
	        int roundsPlayed = 0;
	        int totalScore = 0;
	        int streak = 0;
	        String playAgain;
	        
	        System.out.println("~*~*~*~ Welcome to the Number Guessing Game! ~*~*~*~\n"); //welcome message
	        System.out.println("----------------------Rules-------------------------\n"); //listing of rules below
	        System.out.println("1. Try and Guess what the random number between 1 - 100 \n2. You will get a message if the guess is too high, too low or if you've won the round!"
	        		+ "\n3. You Have 7 tries to guess the random number \n               Good Luck!!!");
	        
	        do {
	            roundsPlayed++; //increments at every loop
	            int attempts = 0;
	            int maxAttempts = 7;
	            int randomNumber = random.nextInt(100) + 1; //  number between 1 and 100
	            boolean guessCorrect = false;
	            
	            System.out.println("\n~*~*~*~ Round " + roundsPlayed + ": Guess the number between 1 and 100 ~*~*~*~");
	            
	            while (attempts < maxAttempts && !guessCorrect) {
	            	System.out.println("You have " + (maxAttempts - attempts) + " attempts."); //lets the player know how much guess they have left
	                System.out.print("\nEnter your guess: ");
	                int guess = scanner.nextInt();
	                attempts++;
	                
	                if (guess == randomNumber) {
	                    System.out.println("\n~*~*~*~ Congratulations! You guessed the correct number! ~*~*~*~");
	                    guessCorrect = true;
	                    streak += 1;
	                    totalScore += (maxAttempts - attempts + 1); // guesser gets more points for the fewer guesses
	                    System.out.println("\nStreak : "+streak);
	                    
	                } else if (guess < randomNumber) {
	                    System.out.println("\nYour guess is too low. Try again!");
	                } else {
	                    System.out.println("\nYour guess is too high. Try again!");
	                }
	            }
	            
	            if (!guessCorrect) {
	                System.out.println("\n:( Sorry, you've used all attempts. The correct number was: " + randomNumber);
	                streak = 0;
	            }
	            
	            System.out.println("\nYour score for this round: " + (guessCorrect ? (maxAttempts - attempts + 1) : 0));
	            System.out.print("~*~ Do you want to play again? (yes/no): ");
	            playAgain = scanner.next();
	            
	        } while (playAgain.equalsIgnoreCase("yes"));
	        //ending messages
	        System.out.println("\n======Game Over! Total rounds played: " + roundsPlayed + "======");
	        System.out.println("========Your total score: " + totalScore + "======");
	        
	        System.out.println("~*~*~*~*~*~*~*~ Thank you for playing! ~*~*~*~*~*~*~*~");
	        
	        scanner.close();
	    }

}
