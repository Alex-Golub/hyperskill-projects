package search;

import java.util.Collections;
import java.util.List;

/** Created by ag on 04-Jun-20 9:25 PM */
public class PeopleSearchEngine {

    private final PersonDB personDB;

    public PeopleSearchEngine(PersonDB personDB) {
        this.personDB = personDB;
    }

    public void search(String query) {
        printFoundData(this.personDB.getInvertedIndex()
                .getOrDefault(query, Collections.emptyList()));
    }

    private void printFoundData(List<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("No matching people found.");
            return;
        }

        System.out.println(list.size() + " persons found:");
        list.forEach(idx -> System.out.println(this.personDB.getPersonList().get(idx)));
    }

}
