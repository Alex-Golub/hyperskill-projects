package search;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2 || !"--data".equals(args[0])) {
            System.err.println("No data source");
            return;
        }

        UI app = new UI();
        app.start(new File(args[1]));
    }
}
