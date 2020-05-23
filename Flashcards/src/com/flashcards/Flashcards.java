package com.flashcards;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Flashcards {

  private final Scanner sc;
  private List<Card> cardsStack;
  private Logger logger;

  public Flashcards() {
    this.cardsStack = new ArrayList<>();
    this.logger = Logger.getInstance();
    this.sc = new Scanner(System.in);
  }

  public void add() {
    // get card term from user and check if exists
    logger.logOutput("The card:");
    String term = sc.nextLine();
    logger.logInput(term);
    for (Card card : cardsStack) {
      if (card.getTerm().equalsIgnoreCase(term)) {
        logger.logOutput("The card \"" + term + "\" already exists.\n");
        return;
      }
    }

    // get card definition from user and check if exists
    logger.logOutput("The definition of the card:");
    String definition = sc.nextLine();
    logger.logInput(definition);
    for (Card card : cardsStack) {
      if (card.getDefinition().equalsIgnoreCase(definition)) {
        logger.logOutput("The card definition \"" + definition + "\" already exists.\n");
        return;
      }
    }

    // this is new card, add it to stack
    cardsStack.add(new Card(term, definition));
    logger.logOutput("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n");
  }

  public void remove() {
    if (cardsStack.isEmpty()) {
      logger.logOutput("Cards Stack is empty!\n");
      return;
    }

    logger.logOutput("The card:");
    String term = sc.nextLine();
    logger.logInput(term);
    for (Card card : cardsStack) {
      if (card.getTerm().equalsIgnoreCase(term)) {
        cardsStack.remove(card);
        logger.logOutput("The card has been removed.\n");
        return;
      }
    }
    logger.logOutput("Can't remove \"" + term + "\": there is no such card.\n");
  }

  // you shouldn't erase the cards that aren't in the file.
  // If the imported card already exists, it should update the old one
  public void loadCards(String loadFile) {
    String fName;
    if (loadFile.isEmpty()) { // save to external file during run-time
      logger.logOutput("File name:");
      fName = sc.nextLine();
      logger.logInput(fName);
      File file = new File(fName);
      if (!file.exists()) {
        logger.logOutput("File not found.\n");
        return;
      }
    } else { // read on app startup
      fName = loadFile;
    }

    // read external file line-by-line (3 lines in one term:definition:mistakes)
    // build new card and add it to stack if not present
    try {
      List<String> lines = Files.readAllLines(Paths.get(fName));
      List<Card> loadedCards = new ArrayList<>();
      final int termDefinitionMistake = 3;

      // check for valid number of lines from external file
      if (lines.size() % termDefinitionMistake != 0) {
        logger.logOutput("Error: file contains invalid number of rows, must be multiples of " + termDefinitionMistake);
        return;
      }

      // get term:definition:mistakes triplet from file
      // and add to card stack
      for (int i = 0; i < lines.size(); i += termDefinitionMistake) {
        String term = lines.get(i);
        String definition = lines.get(i + 1);
        try {
          int mistakes = Integer.parseInt(lines.get(i + 2));
          Card newCard = new Card(term, definition);
          newCard.setMistakes(mistakes);
          loadedCards.add(newCard);
        } catch (NumberFormatException nfe) {
          logger.logOutput("Error: number of mistakes is not a valid integer, " +
                  "\"" + term + "\":\"" + definition + "\" hasn't been added");
          continue;
        }
      }
      updateCardsStack(loadedCards);
      logger.logOutput(lines.size() / termDefinitionMistake + " cards have been loaded.\n");
    } catch (IOException e) {
      logger.logOutput("Error: failed to read file.\n");
    }
  }

  // traverse cards loaded from file
  // update cards with same term with the new definition and mistake count from file
  // add to stack if card is new
  private void updateCardsStack(List<Card> loadedCards) {
    for (Card card : loadedCards) {
      int index = getCardByTerm(card.getTerm());
      if (index > -1) { // update card with card from loadedCards
        cardsStack.set(index, card);
      } else { // card not found, add new card stack
        cardsStack.add(card);
      }
    }
  }

  private int getCardByTerm(String term) {
    for (int i = 0; i < cardsStack.size(); ++i) {
      if (cardsStack.get(i).getTerm().equalsIgnoreCase(term)) {
        return i;
      }
    }
    return -1;
  }

  public void saveCards(String saveTo) {
    String fName;
    if ( saveTo.isEmpty() ) {
      logger.logOutput("File name:");
      fName = sc.next();
      logger.logInput(fName);
      sc.nextLine(); // clear \n
      if (fName.contains("\\s+") // check for spaces
              || fName.indexOf(".") != fName.lastIndexOf(".") // check if more then one period
              || fName.indexOf(".") == -1 // no file extension
              || !".txt".equals(fName.substring(fName.length() - 4))) { // check extension
        logger.logOutput("Error: invalid file name, should be .txt file");
        return;
      }
    } else {
      fName = saveTo;
    }

    // create new file in user specified directory
    // and save cards as term \n definition \n mistakes
    try (FileWriter fw = new FileWriter(new File(fName), false)) { // overwrite
      for (var card : cardsStack) { // TODO: add Term: Def: Mistakes:
        fw.write(card.getTerm() + "\n");
        fw.write(card.getDefinition() + "\n");
        fw.write(card.getMistakes() + "\n");
      }
      logger.logOutput(cardsStack.size() + " cards have been saved.\n");
    } catch (IOException e) {
      logger.logOutput("Error: failed to write to file");
    }
  }

  public void ask() {
    if (cardsStack.size() == 0) {
      logger.logOutput("Error: there are no cards!");
      return;
    }

    int times = getUserInput();
    Random rnd = new Random();
    while (times-- > 0) {
      int rndIndex = rnd.nextInt(cardsStack.size());
      Card randomCard = cardsStack.get(rndIndex);
      logger.logOutput("Print the definition of \"" + randomCard.getTerm() + "\":");
      String answer = sc.nextLine();
      logger.logInput(answer);
      if (answer.equalsIgnoreCase(randomCard.getDefinition())) {
        logger.logOutput("Correct answer\n");
      } else {
        randomCard.setMistakes(randomCard.getMistakes() + 1);
        String res = "Wrong answer. The correct one is \"" + randomCard.getDefinition() + "\"";

        // check if answer is of other term
        Card otherCard = answerOfOtherTerm(answer);
        if (otherCard != null) {
          res += ", you've just written the definition of \"" + otherCard.getTerm() + "\"";
        }
        res += ".\n";
        logger.logOutput(res);
      }
    }
  }

  private int getUserInput() {
    boolean validInput = false;
    int times = 0;
    while (!validInput) {
      logger.logOutput("How many times to ask?");
      try {
        times = sc.nextInt();
        logger.logInput(times + "");
        if (times < 1) {
          logger.logOutput("Error: Enter number grater then 0");
        } else {
          validInput = true;
        }
      } catch (InputMismatchException e) {
        logger.logOutput("Error: please enter only numbers");
      }
      sc.nextLine(); // clear \n
    }
    return times;
  }

  private Card answerOfOtherTerm(String answer) {
    for (Card card : cardsStack) {
      if (card.getDefinition().equalsIgnoreCase(answer)) {
        return card;
      }
    }
    return null;
  }

  // prints the term of the card that has the most mistakes.
  // for multiple hardest cards, all will be listed
  public void hardestCard() {
    // find max number of mistakes
    int max = 0;
    for (Card card : cardsStack) {
      if (card.getMistakes() > max) {
        max = card.getMistakes();
      }
    }

    if (max == 0) {
      logger.logOutput("There are no cards with errors.\n");
      return;
    }

    StringBuilder terms = new StringBuilder();
    for (Card card : cardsStack) {
      if (card.getMistakes() == max) {
        terms.append("\"" + card.getTerm() + "\", ");
      }
    }

    // check if more then one hardest cards
    StringBuilder sb = new StringBuilder();
    boolean isMoreThenOne = terms.indexOf(",") != terms.lastIndexOf(",");
    if (isMoreThenOne) {
      sb.append("The hardest cards are " + terms);
    } else {
      sb.append("The hardest card is " + terms);
    }

    sb.replace(sb.length() - 2, sb.length(),
            ". You have " + max + " errors answering " + (isMoreThenOne ? "them" : "it") + ".\n");
    logger.logOutput(sb.toString());
  }

  // erases the mistake counts for all cards.
  public void reset() {
    cardsStack.forEach(card -> card.setMistakes(0));
    logger.logOutput("Card statistics has been reset.\n");

  }
}


