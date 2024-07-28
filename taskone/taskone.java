package taskone;

import java.util.Random;
import java.util.Scanner;

public class taskone{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int rounds = 0;
        char playAgain = 'y';
        int maxAttempts = 10;

        System.out.println("Hello Gamers,Guess the Number Game! Made by Sivakumar");

        while (playAgain == 'y' || playAgain == 'Y') {
            rounds++;
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("\nRound " + rounds + ": You have " + maxAttempts + " attempts to guess the number between 1 and 100. \n");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guessed Number Here: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("You Entered Number is to Low the Random Number is to High \n ");
                } else if (guess > number) {
                    System.out.println("You Entered Number is to High the Random Number is to Low \n");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + number + " in " + attempts + " attempts.");
                    score++;
                    correctGuess = true;
                    break;
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
            }

            System.out.print("Do you want to play another round? (y/n): ");
            playAgain = scanner.next().charAt(0);
            maxAttempts = Math.max(1, maxAttempts - 1); // Reduce the number of attempts for the next round
        }

        System.out.println("\nGame Over! You played " + rounds + " rounds with a score of " + score + ". \n");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
