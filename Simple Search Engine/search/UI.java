package search;

import java.io.File;
import java.util.Scanner;

/** Created by ag on 04-Jun-20 8:37 PM */
public class UI {

    private final Scanner scanner;
    private final PeopleSearchEngine personSearchEngine;
    private final PersonDB personDB;

    public UI() {
        this.scanner = new Scanner(System.in);
        this.personDB = new PersonDB();
        this.personSearchEngine = new PeopleSearchEngine(this.personDB);
    }

    public void start(File loadDataFrom) {
        personDB.loadData(loadDataFrom);

        processCommand();
    }

    private void processCommand() {
        boolean exit = false;
        while (!exit) {
            menu();
            String choice = this.scanner.nextLine();
            switch (choice) {
                case "1":
                    search();
                    break;
                case "2":
                    personDB.printAllData();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.");
                    break;
            }

            System.out.println();
        }

        System.out.println("\nBye!");
    }

    private void menu() {
        System.out.println(
                "=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit"
        );
    }

    private void search() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String query = scanner.nextLine().toLowerCase();

        personSearchEngine.search(query);
    }

}
