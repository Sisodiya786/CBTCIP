package Project2;
import java.util.Random;
import java.util.Scanner;
public class Game {
    private int score;
    private int rounds;

    public Game() {
        this.score = 0;
        this.rounds = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number Game!");
        while (playAgain) {
            playRound(scanner);
            rounds++;
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Total Score: " + score);
        scanner.close();
    }

    private void playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfAttempts = 0;
        int maxAttempts = 10;
        boolean hasGuessedCorrectly = false;

        System.out.println("A new round has started! Guess a number between 1 and 100.");

        while (numberOfAttempts < maxAttempts && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess < numberToGuess) {
                System.out.println("The number is higher. Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("The number is lower. Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number.");
                hasGuessedCorrectly = true;
            }
        }

        if (hasGuessedCorrectly) {
            int pointsEarned = maxAttempts - numberOfAttempts + 1;
            score += pointsEarned;
            System.out.println("You've earned " + pointsEarned + " points this round.");
        } else {
            System.out.println("You've used all attempts. The correct number was: " + numberToGuess);
        }
    }
}
