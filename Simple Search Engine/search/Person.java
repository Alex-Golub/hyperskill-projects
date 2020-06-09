package search;

/** Created by ag on 04-Jun-20 8:40 PM */
public class Person {

    private String firstName;
    private String lastName;
    private String email; // optional

    public Person(String[] tokens) {
        if (tokens.length <= 0 || tokens.length > 3)
            throw new IllegalArgumentException("Data can have 1-3 words, first name, last name and email");

        this.email = this.firstName = this.lastName = "";

        switch (tokens.length) {
            case 3: this.email = tokens[2];
            case 2: this.lastName = tokens[1];
            case 1: this.firstName = tokens[0];
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, email)
                .trim(); // if email is empty trim to accommodate first and last name only
    }
}
