import java.util.Scanner;

class Main {
        static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int size = sc.nextInt();
        boolean isAsc = true;
        int prev = sc.nextInt();

        for (int i = 1; i < size && isAsc; ++i) {
            int next = sc.nextInt();
            if (prev >= next) {
                isAsc = false;
            } else {
                prev = next;
            }
        }

        System.out.println(isAsc);
    }
}