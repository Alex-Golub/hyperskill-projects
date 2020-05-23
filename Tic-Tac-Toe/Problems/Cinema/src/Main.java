import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        // get user input
        int r = sc.nextInt();
        int s = sc.nextInt();
        sc.nextLine(); // clear \n char from scanner buffer

        if (s == 0) { // cinema didn't bought any seats, what a shame!
            System.out.println(0);
            return;
        }

        // parse each row into a concatenated string i.e: 0 1 0 1 ==> 0101
        String[] cinema = new String[r];
        for (int i = 0; i < r; i++) {
            cinema[i] = sc.nextLine().replaceAll("\\s+", "");
        }
        int k = sc.nextInt();

        // create number of seats required in a row as a string
        StringBuilder reqSeats = new StringBuilder();
        for (int i = 0; i < k; i++) {
            reqSeats.append("0");
        }

        // find if there is a row which have the required
        // free seats in a row
        int result = 0;
        for (int i = 0; i < r; i++) {
            if (cinema[i].indexOf(reqSeats.toString()) != -1) {
                result = i + 1;
                break;
            }
        }
        System.out.println(result);

    }
}