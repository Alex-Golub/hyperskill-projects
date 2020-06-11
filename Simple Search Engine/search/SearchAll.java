package search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Print lines containing all words from the query
 *
 * Created by ag on 11-Jun-20 7:26 PM
 */
public class SearchAll extends SearchStrategy {

  @Override
  public void search(String query, PersonDB personDB) {
    Set<Integer> dataFound = new HashSet<>();
    String[] tokens = query.split("\\s+");

    for (String token : tokens) {
      List<Integer> lines = personDB.getInvertedIndex().get(token);

      /* Set intersection */
      if (lines != null) {
        if (dataFound.isEmpty())
          dataFound.addAll(lines);
        else
          dataFound.retainAll(lines);
      }
    }

    super.getPeople(personDB, dataFound);
  }

}
