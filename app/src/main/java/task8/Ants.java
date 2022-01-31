package task8;

import java.util.Random;

/**
 * A program that simulates an ant walking over a chessboard, counting the steps.
 */
public class Ants {
  /**
   * Calculates how many steps it takes for an ant to walk over a chessboard.
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    Random rand = new Random();

    int totalSteps = 0;
    for (int i = 1; i <= 10; i++) {
      int steps = 0;

      boolean[][] chessboard = new boolean[8][8];

      for (int j = 0; j < chessboard.length; j++) {
        for (int k = 0; k < chessboard[j].length; k++) {
          chessboard[j][k] = false;
        }
      }

      int positionX = rand.nextInt(7);
      int positionY = rand.nextInt(7);

      chessboard[positionX][positionY] = true;

      while (!checkIfDone(chessboard)) {
        boolean hasMoved = false;
        while (!hasMoved) {
          // Choose direction.
          int direction = rand.nextInt(4) + 1;
          if (direction == 1) {
            if (positionX < 7) {
              // If the position exists, move one step to the right.
              positionX++;
              chessboard[positionX][positionY] = true;
              hasMoved = true;
              steps++;
            }
          } else if (direction == 2) {
            if (positionY < 7) {
              // If the position exists, move one step down.
              positionY++;
              chessboard[positionX][positionY] = true;
              hasMoved = true;
              steps++;
            }
          } else if (direction == 3) {
            if (positionX > 0) {
              // If the position exists, move one step to the left.
              positionX--;
              chessboard[positionX][positionY] = true;
              hasMoved = true;
              steps++;
            }
          } else {
            if (positionY > 0) {
              // If the position exists, move one step up.
              positionY--;
              chessboard[positionX][positionY] = true;
              hasMoved = true;
              steps++;
            }
          }
        }
      }
      System.out.println("Number of steps in simulation " + i + ": " + steps);
      totalSteps += steps;
    }

    double average = totalSteps / 10.0;
    System.out.println("Average number of steps: " + average);
  }

  /**
   * Checks if all chess squares have been walked on.
   *
   * @param chessboard - The chessboard.
   * @return A boolean representing the state of the board.
   */
  private static boolean checkIfDone(boolean[][] chessboard) {
    for (int i = 0; i < chessboard.length; i++) {
      for (int j = 0; j < chessboard[i].length; j++) {
        if (chessboard[i][j] == false) {
          return false;
        }
      }
    }
    return true;
  }
}
