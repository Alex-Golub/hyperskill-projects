package search;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class SearchStrategy {

  protected void printFoundData(List<?> list) {
    if (list == null || list.isEmpty()) {
      System.out.println("No matching people found.");
      return;
    }

    System.out.println(list.size() + " persons found:");
    list.forEach(System.out::println);
  }

  protected void getPeople(PersonDB personDB, Set<Integer> dataFound) {
    this.printFoundData(
            dataFound.stream()
            .map(line -> personDB.getPersonList().get(line))
            .collect(Collectors.toList())
    );
  }

  /* delegating to user chosen search strategy */
  protected abstract void search(String query, PersonDB personDB);

}

