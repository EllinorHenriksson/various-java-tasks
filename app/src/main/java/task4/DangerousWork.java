package task4;

import java.util.Scanner;

/**
 * A program that calculates how many days you have to work to earn a certain amount of money.
 */
public class DangerousWork {
  /**
   * Calculates how many days it takes to earn a certain amount of money.
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("How much would you like to earn? ");
    // double sum = scan.nextDouble();
    int sum = scan.nextInt();

    int days = 0;
    double money = 0.0;
    while (money < sum) {
      days += 1;
      money += 0.01 * Math.pow(2, days - 1);
    } 
    System.out.println("It will take " + days + " days to earn the money.");
    scan.close();
  }
}
