package search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Print lines that do not contain words from the query at all
 *
 * Created by ag on 11-Jun-20 8:23 PM
 */
public class SearchNone extends SearchStrategy {

  @Override
  protected void search(String query, PersonDB personDB) {
    Set<Integer> values = new HashSet<>();

    personDB.getInvertedIndex()
            .values()
            .forEach(values::addAll);

    String[] tokens = query.split("\\s+");

    for (String token : tokens) {
      List<Integer> lines = personDB.getInvertedIndex().get(token);

      /* Set subtraction, remove from values all same entries that in lines */
      if (lines != null) {
        values.removeAll(lines);
      }
    }

    super.getPeople(personDB, values);
  }

}
