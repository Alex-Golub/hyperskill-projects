package readability;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int symbols = scanner.nextLine().length();
    System.out.println(symbols > 100 ? "HARD" : "EASY");
  }
}