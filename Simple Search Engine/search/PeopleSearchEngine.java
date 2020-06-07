package search;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ag on 04-Jun-20 9:25 PM
 */
public class PeopleSearchEngine {

    private final PersonDB personDB;

    public PeopleSearchEngine(PersonDB personDB) {
        this.personDB = personDB;
    }

    public void search(String query) {
        List<Person> foundData = this.personDB
                .getPersonList()
                .stream()
                .filter(p -> p.toString().toLowerCase().contains(query))
                .collect(Collectors.toList());

        printFoundData(foundData);
    }

    private void printFoundData(Collection<Person> people) {
        if (people.isEmpty()) {
            System.out.println("\nNo matching people found.");
            return;
        }

        people.forEach(System.out::println);
    }

}
