package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ag on 04-Jun-20 9:36 PM
 */
public class PersonDB {

    private final List<Person> personList;

    public PersonDB() {
        this.personList = new ArrayList<>();
    }

    public void loadData(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                processLine(scanner.nextLine());
            }
        } catch (FileNotFoundException fnf) {
            System.err.println(fnf.getMessage());
        }
    }

    private void processLine(String line) {
        String[] tokens = line.trim().split("\\s+");

        switch (tokens.length) {
            case 3: // user provided: firstName, lastName and email
                personList.add(new Person(tokens[0], tokens[1], tokens[2]));
                break;
            case 2: // user provided: firstName, lastName
                personList.add(new Person(tokens[0], tokens[1]));
                break;
            case 1: // user provided single word assume it is firstName
                personList.add(new Person(tokens[0]));
                break;
            default: // data contains more then 3 words or less then 1 is not permitted
                System.out.println("Data can have up to 3 words, first name, last name and email.");
                break;
        }
    }

    public List<Person> getPersonList() {
        // Don't allow client to make modification on personList data
        return Collections.unmodifiableList(this.personList);
    }

    public void printAllData() {
        System.out.println("\n=== List of people ===");
        personList.forEach(System.out::println);
    }
}
