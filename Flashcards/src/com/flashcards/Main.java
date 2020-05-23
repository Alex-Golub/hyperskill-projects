package com.flashcards;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  final static String ADD_CARD = "add";
  final static String REMOVE_CARD = "remove";
  final static String LOAD_CARDS = "import";
  final static String SAVE_CARDS = "export";
  final static String ASK = "ask";
  final static String EXIT = "exit";
  final static String LOG = "log";
  final static String HARDEST_CARD = "hardest card";
  final static String RESET_STATS = "reset stats";
  final static String INITIAL_IMPORT = "-import";
  final static String FINAL_EXPORT = "-export";

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getInstance();
    Flashcards cards = new Flashcards();

    String saveToFileOnExit = checkCmdArgs(args, cards);

    boolean quit = false;
    while (!quit) {
      logger.logOutput("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
      String choice = sc.nextLine();
      logger.logInput(choice);

      switch (choice.toLowerCase()) {
        case ADD_CARD: // add a single card
          cards.add();
          break;
        case REMOVE_CARD: // remove a single card
          cards.remove();
          break;
        case LOAD_CARDS: // load cards from file ("deserialization")
          cards.loadCards("");
          break;
        case SAVE_CARDS: // save cards to file ("serialization"): export
          cards.saveCards("");
          break;
        case ASK: // ask for a definition of some random cards
          cards.ask();
          break;
        case LOG: // saves the application log to the given file
          log(logger, sc);
          break;
        case HARDEST_CARD: // prints the term of the card that has the most mistakes
          cards.hardestCard();
          break;
        case RESET_STATS: // erases the mistake counts for all cards.
          cards.reset();
          break;
        case EXIT: // exit the program
          System.out.println("Bye bye!");
          if ( !saveToFileOnExit.isEmpty() ) { // save current session to file
            cards.saveCards(saveToFileOnExit);
          }
          quit = true;
          break;
        default:
          logger.logOutput("Error: invalid operation");
      }
    }
  }

  private static String checkCmdArgs(String[] args, Flashcards cards) {
    String loadOnStartFileName = "";
    String saveOnExitFileName = "";
    for (int i = 0; i < args.length; i += 2) {
      if (args[i].equals(INITIAL_IMPORT)) {
        loadOnStartFileName = args[i + 1];
      }
      if (args[i].equals(FINAL_EXPORT)) {
        saveOnExitFileName = args[i + 1];
      }
    }

    if ( !loadOnStartFileName.isEmpty() ) {
      cards.loadCards(loadOnStartFileName);
    }

    return saveOnExitFileName;
  }

  private static void log(Logger logger, Scanner sc) {
    logger.logOutput("File name:");
    String fName = sc.nextLine();
    logger.logInput(fName);
    File file = new File(fName);
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        logger.logOutput("Error: failed to create log file!");
      }
    }
    if (logger.logToFile(file)) {
      logger.logOutput("The log has been saved.\n");
    } else {
      logger.logOutput("Error: failed to log to " + file.getName());
    }
  }
}

