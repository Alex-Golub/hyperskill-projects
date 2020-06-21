package readability;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Split text by following punctuations: ! . ?
    String[] sentences = scanner.nextLine().split("[!.?]");

    // Sum total of words in each sentence
    int totalWords = String.join(" ", sentences)
            .split("\\s+")
            .length;

    System.out.println(totalWords * 1.0 / sentences.length > 10.0 ? "HARD" : "EASY");

  }
}
