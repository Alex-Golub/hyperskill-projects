package readability;

/**
 * Created by ag on 24-Jun-20 1:09 PM
 */
public class TextAnalyzer {

  private static final String[] gradeLevel =
          {"5-6", "6-7", "7-9", "9-10", "10-11", "11-12", "12-13",
           "13-14", "14-15", "15-16", "16-17", "17-18", "18-24", "24+"};

  private TextAnalyzer() {}

  public static int countWords(String text) {
    return text.isBlank() ? 0 : text.split("\\s+").length;
  }

  public static int countSentences(String text) {
    return text.isBlank() ? 0 : text.split("[!.?]+").length;
  }

  /** number of characters is any visible symbol except space, newline "\n" and tab "\t" */
  public static int countCharacters(String text) {
    return text.replaceAll("\\s+", "").length();
  }

  /** https://en.wikipedia.org/wiki/Automated_readability_index */
  public static double ARIScore(String text) {
    int chars = countCharacters(text);
    int words = countWords(text);
    int sentences = countSentences(text);

    double score = 4.71 * chars / words + 0.5 * words / sentences - 21.43;

    // Use BigDecimal for maximal floating point precision
    return Double.compare(score, 1.0) < 0 ? 1.0 :
           Double.compare(score, 14.0) > 0 ? 14.0 : score;
  }

  public static String comprehensionAge(double ARIScore) {
    return gradeLevel[(int) Math.ceil(ARIScore) - 1];
  }

}
