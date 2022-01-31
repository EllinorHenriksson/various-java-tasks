package task5;

import java.util.Scanner;

/**
 * A program that prints a diamond wich size is given by the user.
 */
public class Diamonds {
  /**
   * Prints a diamond wich size (given as a positive integer) is decided by the user.
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("Enter a positive number: ");

    if (!scan.hasNextInt()) {
      throw new Error("Wrong input type.");
    }

    int number = scan.nextInt();
    if (number > 0) {
      for (int i = 1; i <= number; i++) {
        for (int j = 1; j < number + i; j++) {
          if (j <= number - i) {
            System.out.print(" ");
          } else {
            System.out.print("*");
          }
        }
        System.out.print("\n");
      }
      for (int i = 1; i < number; i++) {
        for (int j = 1; j < number * 2 - i; j++) {
          if (j <= i) {
            System.out.print(" ");
          } else {
            System.out.print("*");
          }
        }
        System.out.print("\n");
      }
    }
    scan.close();
  }
}
