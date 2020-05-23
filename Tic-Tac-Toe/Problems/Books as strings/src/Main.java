class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("title=" + title +
                ",yearOfPublishing=" + yearOfPublishing +
                ",authors=[");
        for (int i = 0; i < authors.length; i++) {
            res.append(authors[i] + ",");
        }
        // replace last "," with "]"
        res.replace(res.length() - 1, res.length(), "]");
        return res.toString();

    }
}