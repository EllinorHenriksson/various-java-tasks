package task6;

import java.util.Random;
import java.util.Scanner;

/**
 * A program that lets the user play sciccors, rock or paper against the computer.
 */
public class GameSrp {
  /**
   * Lets the user play scissors, rock or paper against the computer.
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in, "utf-8");

    System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");

    int answerUser = scan.nextInt();

    int countDraw = 0;
    int countUser = 0;
    int countComputer = 0;

    while (answerUser != 0) {
      int answerComputer = rand.nextInt(3) + 1;
      String message = "";
      if (answerUser == answerComputer) {
        countDraw++;
        message = "It's a draw!";
      } else if (answerUser == 1 && answerComputer == 2) {
        countComputer++;
        message = "You lost, computer had rock!";
      } else if (answerComputer == 1 && answerUser == 2) {
        countUser++;
        message = "You won, computer had scissors!";
      } else if (answerUser == 1 && answerComputer == 3) {
        countUser++;
        message = "You won, computer had paper!";
      } else if (answerComputer == 1 && answerUser == 3) {
        countComputer++;
        message = "You lost, computer had scissors!";
      } else if (answerUser == 2 && answerComputer == 3) {
        countComputer++;
        message = "You lost, computer had paper!";
      } else if (answerComputer == 2 && answerUser == 3) {
        countUser++;
        message = "You won, computer had rock!";
      }
      System.out.println(message);

      System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");

      answerUser = scan.nextInt();
    }

    System.out.println("Score: " + countUser + " (you) " + countComputer + " (computer) " + countDraw + " (draw)");

    scan.close();
  }
}
