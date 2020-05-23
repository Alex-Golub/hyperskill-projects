import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) { arr[i] = sc.nextInt(); }

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        // assume numbers are next to each other
        boolean isNext = true;
        for (int i = 0; i < size && isNext; i++) {
            int curr = arr[i];
            if (curr == n1 && i > 0 && arr[i - 1] == n2) {
                isNext = false;
                continue;
            }
            if (curr == n1 && i < size - 1 && arr[i + 1] == n2) {
                isNext = false;
                continue;
            }
        }

        System.out.println(isNext);

    }
}