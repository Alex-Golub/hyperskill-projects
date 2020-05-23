import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < size; ++i) {
            int input = sc.nextInt();
            if (input < minValue) {
                minValue = input;
            }
        }
        System.out.println(minValue);
    }
}