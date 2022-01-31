package task7;

import java.util.Scanner;

/**
 * A program that lets the user find out what weekday a certain date is.
 */
public class DayOfWeek {
  /**
   * Lets the user find out what weekday a certain day is.
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "utf-8");

    System.out.print("Enter year, month (1-12), and day (1-31): ");
    int year = scan.nextInt();
    int month = scan.nextInt();
    if (month == 1) {
      month = 13;
      year--;
    } else if (month == 2) {
      month = 14;
      year--;
    }
    int day = scan.nextInt();

    int q = day;
    int m = month;
    int j = year / 100;
    int k = year % 100;

    int h = (q + ((26 * (m + 1)) / 10) + k + k / 4 + j / 4 + 5 * j) % 7;

    String weekday = "";

    switch (h) {
      case 0:
        weekday = "Saturday";
        break;
      case 1:
        weekday = "Sunday";
        break;
      case 2:
        weekday = "Monday";
        break;
      case 3:
        weekday = "Tuesday";
        break;
      case 4:
        weekday = "Wednesday";
        break;
      case 5:
        weekday = "Thursday";
        break;
      case 6:
        weekday = "Friday";
        break;
      default:
        break;
    }

    System.out.println("Day of week is " + weekday);
    scan.close();
  }
}
