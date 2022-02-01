package task10;

import java.util.Scanner;

/**
 * A program that prints a calendar for the given month and year.
 */
public class PrintCalendar {
  /**
   * Prints a calendar for the month and year given by the user.
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "utf-8");

    System.out.print("Enter year and month (1-12): ");
    int year = scan.nextInt();
    int month = scan.nextInt();

    String calendar = getCalendar(year, month);

    System.out.println(calendar);

    scan.close();
  }

  /**
   * Gets a calendar for a certain month and year.
   *
   * @param year - The year.
   * @param month - The month (0-12).
   * @return The calender as a string.
   */
  private static String getCalendar(int year, int month) {
    String monthName = getMonthName(month);
    
    int numberOfDays = daysInMonth(year, month);
    int firstWeekday = getWeekday(year, month, 1);
    String table = getCalendarTable(numberOfDays, firstWeekday);

    return monthName + " " + year + "\n" + table;
  }

  /**
   * Calculates how many days there are in the specified month.
   *
   * @param year - The year of the month.
   * @param month - The month to check.
   * @return The number of days in the month.
   */
  private static int daysInMonth(int year, int month) {
    if (month == 2) {
      if (isLeapYear(year)) {
        return 29;
      } else {
        return 28;
      }
    } else if (month < 8) {
      if (month % 2 == 0) {
        return 30;
      } else {
        return 31;
      }
    } else {
      if (month % 2 == 0) {
        return 31;
      } else {
        return 30;
      }
    }
    
  }

  /**
   * Checks if a year is a leap year.
   *
   * @param year - The year to check.
   * @return True if it is a leap year, otherwise false.
   */
  private static boolean isLeapYear(int year) {
    if (Integer.toString(year).substring(2).equals("00")) {
      if (year % 400 == 0) {
        return true;
      } else {
        return false;
      }
    } else {
      if (year % 4 == 0) {
        return true;
      } else {
        return false;
      }
    }
  }

  /**
   * Gets the weekday (0-6, corresponding to Monday-Sunday) for a date.
   *
   * @param year - The year of the date.
   * @param month - The month of the date (1-12).
   * @param day - The day of the date (1-31).
   * @return The weekday (0-6).
   */
  private static int getWeekday(int year, int month, int day) {
    if (month == 1) {
      month = 13;
      year--;
    } else if (month == 2) {
      month = 14;
      year--;
    }

    int q = day;
    int m = month;
    int j = year / 100;
    int k = year % 100;

    int h = (q + ((26 * (m + 1)) / 10) + k + k / 4 + j / 4 + 5 * j) % 7;

    if (h > 1) {
      return h - 2;
    } else {
      return h + 5;
    }
  }

  /**
   * Gets the name of a month given as an integer (1-12).
   *
   * @param month - The month to get the name of.
   * @return The name of the month.
   */
  private static String getMonthName(int month) {
    String monthName = "";
    switch (month) {
      case 1:
        monthName = "January";
        break;
      case 2:
        monthName = "February";
        break;
      case 3:
        monthName = "Mars";
        break;
      case 4:
        monthName = "April";
        break;
      case 5:
        monthName = "May";
        break;
      case 6:
        monthName = "June";
        break;
      case 7:
        monthName = "July";
        break;
      case 8:
        monthName = "August";
        break;
      case 9:
        monthName = "September";
        break;
      case 10:
        monthName = "October";
        break;
      case 11:
        monthName = "November";
        break;
      case 12:
        monthName = "December";
        break;
      default:
        break;
    }
    return monthName;
  }

  /**
   * Gets a string representing a calendar table with the dates in position for each weekday.
   *
   * @param numberOfDays - The number of dates in the month.
   * @param firstWeekday - The weekday (0-6, corresponding to Mon-Sun) of the 1st of that month.
   * @return A string representing a calendar table.
   */
  private static String getCalendarTable(int numberOfDays, int firstWeekday) {
    String heading = "Mon Tue Wed Thu Fri Sat Sun";
    String dashes = getDashes(heading);
    String table = dashes + "\n" + heading + "\n";
    int count = 0;
    for (int i = 0; i < firstWeekday; i++) {
      table += "    ";
      count++;
    }
    for (int i = 1; i <= numberOfDays; i++) {
      if (i < 10) {
        table += "  " + i;
      } else {
        table += " " + i;
      }

      count++;

      if (count % 7 == 0) {
        table += "\n";
      } else {
        table += " ";
      }
    }
    return table;
  }

  /**
   * Gets a string with dashes which length is the same as the length of the parameter 'row'.
   *
   * @param row - The string which length to use.
   * @return A string with dashes the lengt of 'row'.
   */
  private static String getDashes(String row) {
    String dashes = "";
    for (int i = 0; i < row.length(); i++) {
      dashes += "-";
    }
    return dashes;
  }
}
