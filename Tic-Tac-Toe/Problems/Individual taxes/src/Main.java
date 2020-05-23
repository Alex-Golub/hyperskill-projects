import java.util.*;

public class Main {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        String[] yearIncome = sc.nextLine().split("\\s+");
        String[] taxPer = sc.nextLine().split("\\s+");

        double maxTax = 0;
        int maxIndex = 1;
        for (int i = 0; i < n; ++i) {
            double tax = Integer.parseInt(yearIncome[i]) * (Integer.parseInt(taxPer[i]) / 100.0);
            if (tax > maxTax) {
                maxTax = tax;
                maxIndex = i + 1;
            }

        }
        System.out.println(maxIndex);

    }
}