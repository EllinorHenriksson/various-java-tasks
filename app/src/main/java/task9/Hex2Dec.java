package task9;

import java.util.Scanner;

/**
 * A program that converts a hexadecimal given by the user to a decimal.
 */
public class Hex2Dec {
  /**
   * The main method of the program.
   *
   * @param args - Input (if available).
   */
  public static void main(String[] args) {
    System.out.print("Enter a hexadecimal: ");
    Scanner scan = new Scanner(System.in, "utf-8");
    String hex = scan.next();
    int decimal = hexToDecimal(hex);
    System.out.println("Decimal value for " + hex + ": " + decimal);
    scan.close();
  }

  /**
   * Converts a hexadecimal to a decimal.
   *
   * @param hex - The hexadecimal value.
   * @return The corresponding decimal value.
   */
  private static int hexToDecimal(String hex) {
    int dec = 0;
    for (int i = 0; i < hex.length(); i++) {
      dec += Character.getNumericValue(hex.charAt(i)) * Math.pow(16.0, hex.length() - (i + 1));
    }
    return dec;
  }
}
