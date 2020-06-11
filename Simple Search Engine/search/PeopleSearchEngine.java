package search;

/** Created by ag on 04-Jun-20 9:25 PM */
public class PeopleSearchEngine {

  private final PersonDB personDB;
  private SearchStrategy searchStrategy;

  public PeopleSearchEngine(PersonDB personDB) {
    this.personDB = personDB;
  }

  public void setSearchStrategy(SearchStrategy searchStrategy) {
    this.searchStrategy = searchStrategy;
  }

  public void search(String query) {
    searchStrategy.search(query, this.personDB);
  }

}
