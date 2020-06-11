package search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Print lines containing at least one word from the query.
 *
 * Created by ag on 11-Jun-20 8:18 PM
 */
public class SearchAny extends SearchStrategy {

  @Override
  protected void search(String query, PersonDB personDB) {
    Set<Integer> dataFound = new HashSet<>();
    String[] tokens = query.split("\\s+");

    for (String token : tokens) {
      List<Integer> lines = personDB.getInvertedIndex().get(token);

      /* Set adding all line entries */
      if (lines != null) {
        dataFound.addAll(lines);
      }
    }

    super.getPeople(personDB, dataFound);
  }
}
