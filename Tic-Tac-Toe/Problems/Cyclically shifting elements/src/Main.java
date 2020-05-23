import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine(); // clear "\n" from input buffer
        String[] numbers = scanner.nextLine().split(" ");

        StringBuilder res = new StringBuilder(numbers[size - 1] + " ");
        for (int i = 0; i < size - 1; ++i) {
            res.append(numbers[i] + " ");
        }

        System.out.println(res.toString().trim());
    }
}