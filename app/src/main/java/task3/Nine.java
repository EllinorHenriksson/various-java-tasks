package task3;

import java.util.Random;
import java.util.Scanner;

/**
 * A program that lets the user play a round of dice with the computer. Closest to 9 wins, above 9 gets fat.
 */
public class Nine {
  /**
   * Simulates a game of dice between the user and the computer. 
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in, "utf-8");
    
    System.out.print("Ready to play? (Y/N) ");

    if (scan.next().toLowerCase().equals("y")) {
      int user1 = rollDice(rand);
      int userSum = user1;
      System.out.print("You rolled " + user1 + ". Want to roll again? (Y/N) ");
      if (scan.next().toLowerCase().equals("y")) {
        int user2 = rollDice(rand);
        userSum = user1 + user2;
        System.out.println("You rolled " + user2 + ". Total: " + userSum);
      }

      int computer1 = rollDice(rand);
      int computerSum = computer1;
      System.out.println("The computer rolled " + computer1);
      if (computer1 <= 4) {
        int computer2 = rollDice(rand);
        computerSum = computer1 + computer2;
        System.out.println("The computer rolled again and got " + computer2 + ". Total: " + computerSum);
      }

      System.out.println(compareResults(userSum, computerSum, "User", "Computer"));
    } else {
      System.out.println("Terminated.");
    }

    scan.close();
  }

  /**
   * Gets a random integer between 1 and 6.
   *
   * @param rand - The Random object to use.
   * @return A random integer between 1 and 6.
   */
  private static int rollDice(Random rand) {
    return rand.nextInt(6) + 1;
  }

  /**
   * Compares the scores of two players and returns the result as a string.
   *
   * @param score1 - The score of the first player.
   * @param score2 - The score of the second player.
   * @param player1 - The name of the first player.
   * @param player2 - The name of the second player.
   * @return A text representing the result.
   */
  private static String compareResults(int score1, int score2, String player1, String player2) {
    String message;
    if (score1 >= 10 && score2 >= 10) {
      message = "Both got fat. No one wins.";
    } else if (score1 >= 10) {
      message = player1 + " got fat. " + player2 + " wins!";
    } else if (score2 >= 10) {
      message = player2 + " got fat. " + player1 + " wins!";
    } else if (score1 == score2) {
      message = "Tied!";
    } else if (9 - score1 < 9 - score2) {
      message = player1 + " wins!";
    } else {
      message = player2 + " wins!";
    }

    return message;
  }
}
