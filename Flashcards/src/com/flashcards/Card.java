package com.flashcards;

public class Card {

  private String term;
  private String definition;
  private int mistakes;

  public Card(String term, String definition) {
    this.term = term;
    this.definition = definition;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public int getMistakes() {
    return mistakes;
  }

  public void setMistakes(int mistakes) {
    if (mistakes < 1) {
      this.mistakes = 0;
    } else {
      this.mistakes = mistakes;
    }
  }
}
