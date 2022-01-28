package task5;

import java.util.Scanner;

/**
 * The program.
 */
public class Diamonds {
  /**
   * The main method.
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
      /*
      int count = number;
      for (int i = 0; i < number; i++) {
        for (int j = 0; j < count; j++) {
          if (j < number - count) {
            System.out.print(" ");
          } else {
            System.out.print("*");
          }
        }
        System.out.print("\n");
        count++;
      }
      for (int i = 0; i < number - 1; i++) {
        for (int j = 0; j < count - 1; j++) {
          if (j < number - count) {
            System.out.print(" ");
          } else {
            System.out.print("*");
          }
        }
        count--;
      }
      */
      for (int i = 1; i <= number * 2; i++) {
        if (i <= number) {
          // Mot mitten
          for (int j = 1; j < number + i; j++) {
            if (j <= number - i) {
              System.out.print(" ");
            } else {
              System.out.print("*");
            }
          }
        } else {
          // Från mitten
          System.out.println("Från mitten");
        }
        System.out.print("\n");
      }
    }
    scan.close();
  }
}
