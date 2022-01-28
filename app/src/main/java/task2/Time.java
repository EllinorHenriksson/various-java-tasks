package task2;

import java.util.Scanner;

/**
 * A program that calculates the time (hours, minutes and seconds) from a given value of seconds.
 */
public class Time {
  /**
   * Translates seconds to hours, minutes and seconds.
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("Enter the number of seconds: ");
    int seconds = scan.nextInt();
    
    int minutes = 0;
    int hours = 0;

    if (seconds >= 60) {
      minutes = seconds / 60;
      seconds = seconds % 60;

      if (minutes >= 60) {
        hours = minutes / 60;
        minutes = minutes % 60;
      }
    }

    System.out.println("This corresponds to: " + hours + " h, " + minutes + " min and " + seconds + " s.");
    scan.close();
  }
}
