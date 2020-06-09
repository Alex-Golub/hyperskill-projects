package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/** Created by ag on 04-Jun-20 9:36 PM */
public class PersonDB {

    private final List<Person> personList;
    private final Map<String, List<Integer>> invertedIndex;

    public PersonDB() {
        this.personList = new ArrayList<>();
        this.invertedIndex = new HashMap<>(); // The order of pairs is not important
    }

    public void loadData(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                personList.add(new Person(scanner.nextLine().trim().split("\\s+")));
            }
        } catch (FileNotFoundException fnf) {
            System.err.println(fnf.getMessage());
        }

        buildInvertedIndex();
    }

    private void buildInvertedIndex() {
        for (int i = 0, len = getPersonList().size(); i < len; i++) {
            String[] tokens = getPersonList().get(i)
                    .toString().toLowerCase()
                    .split("\\s+");

            for (String token : tokens) {
                this.invertedIndex.computeIfAbsent(token, k -> new ArrayList<>());
                this.invertedIndex.get(token).add(i);
            }
        }
    }

    public List<Person> getPersonList() {
        // Don't allow client to make modification on personList data
        return Collections.unmodifiableList(this.personList);
    }

    public Map<String, List<Integer>> getInvertedIndex() {
        return Collections.unmodifiableMap(this.invertedIndex);
    }

    public void printAllData() {
        System.out.println("\n=== List of people ===");
        personList.forEach(System.out::println);
    }
}
