package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static readability.TextAnalyzer.*;

public class Main {
  public static void main(String[] args) {

    if (args.length < 1) {
      System.out.println("No text file to read... exiting");
      return;
    }

    String text = "";

    try {
      text = Files.readString(Paths.get(args[0]));
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("The text is: \n" + text + "\n");
    System.out.println("Words: " + countWords(text));
    System.out.println("Sentences: " + countSentences(text));
    System.out.println("Characters: " + countCharacters(text));

    double ariScore = ARIScore(text);
    System.out.printf("The score is: %.2f%n", ariScore);
    System.out.println("This text should be understood by " + comprehensionAge(ariScore) + " year olds");

  }
}
